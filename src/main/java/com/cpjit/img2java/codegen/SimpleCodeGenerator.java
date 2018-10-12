/*
 * Copyright 2011-2018 CPJIT Group.
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cpjit.img2java.codegen;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yonghuan
 */
@Component
public class SimpleCodeGenerator implements CodeGenerator {

    private final static Logger LOG = LoggerFactory.getLogger(SimpleCodeGenerator.class);

    @Override
    public void generate(Path src, Path dest) throws IOException {

        if (!Files.exists(dest)) {
            Files.createDirectories(dest);
        }

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(src, "*.json")) {
            for (Path file : ds) {
                JSONReader reader = new JSONReader(new FileReader(file.toFile()));
                JSONObject clazzMeta = (JSONObject) reader.readObject();
                reader.close();

                // 创建java源文件
                String clazzName = upperCamelCase(clazzMeta.getString("en"));
                PrintWriter out = new PrintWriter(new FileWriter(dest.resolve(clazzName + ".java").toFile()));

                // 类注释
                String clazzComment = clazzMeta.getString("zh");
                out.println("/**");
                out.print("* ");
                out.println(clazzComment);
                out.println("*/");

                out.print("public interface ");
                out.print(clazzName);
                out.println(" { ");


                List<JSONObject> attrs = clazzMeta.getJSONArray("attrs").stream()
                        .map(o -> (JSONObject) o)
                        .collect(Collectors.toList());

                validationDuplicateAttrValue(attrs, clazzComment);

                // 按层级分组
                var groupByLeven = attrs.stream()
                        .collect(Collectors.groupingBy(attr -> attr.getString("code").length()))
                        .entrySet()
                        .stream()
                        .collect(Collectors.toList());
                // 按层级排序
                Collections.sort(groupByLeven, Comparator.comparing(group -> group.getKey()));

                final int rootLevel = groupByLeven.stream().map(Map.Entry::getKey).min(Integer::compareTo).get();
                // 生成常量属性
                for (var group : groupByLeven) {
                    Collections.sort(group.getValue(), Comparator.comparing(attr -> attr.getString("code")));
                    for (var attr : group.getValue()) {
                        writeAttr(attr, groupByLeven, group.getKey(), rootLevel, out);
                    }
                }
                out.println(" } ");
                out.flush();
                out.close();
            }
        }

    }

    /**
     * 校验是否存在重复的code值
     */
    private boolean validationDuplicateAttrValue(List<JSONObject> attrs, String clazzComment) {
        var duplicateCode = attrs.stream()
                .collect(Collectors.groupingBy(attr -> attr.getString("code")))
                .entrySet()
                .stream()
                .filter(group -> group.getValue().size() > 1)
                .collect(Collectors.toSet());
        if (duplicateCode.isEmpty()) {
            return false;
        }
        for (var group : duplicateCode) {
            String str = group.getValue().stream()
                    .map(attr -> constantNaming(attr.getString("en")))
                    .collect(Collectors.joining(","));
            LOG.warn("常量值重复，{}: {} ", clazzComment, str);
        }
        return true;
    }

    private void writeAttr(JSONObject attr, List<Map.Entry<Integer, List<JSONObject>>> groupByLeven,
                           int currentLevel, int rootLevel, PrintWriter out) {
        String attrNamePrefix = "", attrCommentPrefix = "";
        if (currentLevel > rootLevel) {
            String str = attr.getString("code").substring(0, currentLevel - rootLevel);
            for (var item : groupByLeven) {
                Integer key = item.getKey();
                if (key.equals(currentLevel - rootLevel)) {
                    for (JSONObject jo : item.getValue()) {
                        String code = jo.getString("code").substring(0);
                        if (code.equals(str)) {
                            attrNamePrefix = constantNaming(jo.getString("en")) + "_";
                            attrCommentPrefix = jo.getString("zh") + "-";
                            break;
                        }
                    }
                }
                if (StringUtils.isNotBlank(attrNamePrefix)) {
                    break;
                }
            }
        }

        String attrName = attrNamePrefix + constantNaming(attr.getString("en"));
        String attrValue = new StringBuilder()
                .append('"')
                .append(attr.getString("code"))
                .append('"')
                .toString();
        if (StringUtils.isBlank(attrValue)) {
            attrValue = "?";
        }
        String attrComment = attr.getString("zh");
        out.println("   /**");
        out.print("    * ");
        out.println(attrCommentPrefix + attrComment);
        out.println("    */");
        out.print("   String ");
        out.print(attrName);
        out.print(" = ");
        out.print(attrValue);
        out.println(";");
    }


    /**
     * 大驼峰命名规则。
     */
    private String upperCamelCase(String name) {
        return parseParts(name).stream()
                .map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .collect(Collectors.joining(""));
    }

    /**
     * 常量命名。
     */
    private String constantNaming(String name) {
        return parseParts(name).stream()
                .map(str -> str.toUpperCase())
                .collect(Collectors.joining("_"));
    }

    private List<String> parseParts(String name) {
        if (name == null) {
            return Collections.emptyList();
        }
        name = name.replaceAll("['\\&\\-\\.,]", "").toLowerCase();
        List<String> parts = Arrays.stream(name.split("\\s+"))
                .filter(str -> !"the".equals(str) && !"and".equals(str) && !(str.startsWith("(") || str.endsWith(")")))
                .collect(Collectors.toList());

        // 存在 aa of bb 这种格式的时候需要交换位置
        int ofIndex = parts.indexOf("of");
        if (ofIndex > 0) {
            List<String> front = parts.subList(0, ofIndex);
            List<String> posterior = parts.subList(ofIndex + 1, parts.size());
            parts = new ArrayList<>(front.size() + posterior.size());
            parts.addAll(posterior);
            parts.addAll(front);
        }
        // 不能以数字打头
        if (NumberUtils.isDigits(parts.get(0))) {
            String first = parts.get(0);
            List<String> posterior = parts.subList(1, parts.size());
            parts = new ArrayList<>(parts.size());
            parts.addAll(posterior);
            parts.add(first);
        }
        return parts;
    }

}
