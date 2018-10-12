package com.cpjit.img2java.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.cpjit.img2java.autoconfigure.BaiduTranslateProperties;
import com.cpjit.img2java.translate.TransApi;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author yonghuan
 */
@RequestMapping("translate")
@RestController
public class TranslateController {

    @Autowired
    private TransApi transApi;
    @Autowired
    private BaiduTranslateProperties translateProperties;

    @GetMapping
    public void translate() throws IOException {
        Path src = translateProperties.getSourceDirectory().getFile().toPath();
        Path dest = translateProperties.getTargetDirectory().getFile().toPath();
        if (!Files.exists(dest)) {
            Files.createDirectories(dest);
        }

        Path logFile = dest.resolve("log.log");
        PrintWriter logWriter = new PrintWriter(new FileWriter(logFile.toFile()));

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(src, "*.json")) {
            for (Iterator<Path> pathIterator = ds.iterator(); pathIterator.hasNext(); ) {
                Path file = pathIterator.next();
                String filename = file.getFileName().toString();
                String classZhName = FilenameUtils.getBaseName(filename);
                JSONObject clazz = getTransResult(classZhName);
                clazz.put("zh", classZhName);
                JSONArray attrs = new JSONArray();
                clazz.put("attrs", attrs);
                JSONReader reader = new JSONReader(new FileReader(file.toFile()));
                JSONArray items = (JSONArray) reader.readObject();
                ListIterator<Object> ltr = items.listIterator();
                boolean error = false;
                while (ltr.hasNext()) {
                    String code = (String) ltr.next();
                    code = StringUtils.trim(code);
                    if (code.startsWith(")") && code.length() == 2) {
                        code = "0" + code.substring(1);
                    }
                    if (!NumberUtils.isDigits(code)) {
                        String log = classZhName + "." + code;
                        System.out.println(log);
                        if (ltr.hasNext()) {
                            ltr.next();
                        }
                        error = true;
                        if (!translateProperties.isIgnoreError()) {
                            break;
                        }
                    }
                    JSONObject attr;
                    if (ltr.hasNext()) {
                        String codeZh = (String) ltr.next();
                        attr = getTransResult(codeZh);
                    } else {
                        attr = new JSONObject();
                    }
                    attr.put("code", code);
                    attrs.add(attr);
                }
                reader.close();

                logWriter.println(classZhName);
                logWriter.flush();
                if (error) {
                    if (!translateProperties.isIgnoreError()) {
                        continue;
                    }
                } else {
                    // 翻译过程没有出错，自动删除源文件
                    if (translateProperties.isAutoClear()) {
                        FileUtils.deleteQuietly(file.toFile());
                    }
                }

                FileWriter fw = new FileWriter(dest.resolve(classZhName + ".json").toFile());
                JSONWriter writer = new JSONWriter(fw);
                writer.writeObject(clazz);
                writer.flush();
                writer.close();
                fw.flush();
                fw.close();
            }
        }
        logWriter.close();
    }

    private JSONObject getTransResult(String zh) throws IOException {
        String simple = zh.split("、")[0];
        JSONObject transResult = (JSONObject) JSONObject.parseObject(transApi.getTransResult(simple, "zh", "en")).getJSONArray("trans_result").get(0);
        JSONObject result = new JSONObject();
        result.put("zh", zh);
        result.put("en", transResult.getString("dst"));
        return result;
    }

}
