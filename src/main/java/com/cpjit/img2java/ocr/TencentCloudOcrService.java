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
package com.cpjit.img2java.ocr;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;
import com.cpjit.img2java.autoconfigure.TencentCloudSecretProperties;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author yonghuan
 */
@Service("tencentCloudOcrService")
public class TencentCloudOcrService implements OcrService {

    private TencentCloudSecretProperties tencentCloudSecretProperties;

    @Autowired
    public void setTencentCloudSecretProperties(TencentCloudSecretProperties tencentCloudSecretProperties) {
        this.tencentCloudSecretProperties = tencentCloudSecretProperties;
    }

    @Override
    public void general(Path src, Path dest) throws IOException {
        final String authorization;
        try {
            authorization = Sign.appSign(tencentCloudSecretProperties.getAppId(), tencentCloudSecretProperties.getSecretId(), tencentCloudSecretProperties.getSecretKey(), null, 3600 * 1000);
        } catch (Exception e) {
            throw new IOException(e);
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(src)) {
            for (final Path file : stream) {
                String filename = file.getFileName().toString();
                if (!"png".equals(FilenameUtils.getExtension(filename))) {
                    continue;
                }
                JSONObject parameter = new JSONObject();
                // 图片转成base64
                byte[] image = Files.readAllBytes(file);
                parameter.put("appid", "" + tencentCloudSecretProperties.getAppId() + "");
                parameter.put("image", Base64.getEncoder().encodeToString(image));

                HttpClient http = HttpClient.newBuilder().build();
                HttpRequest request = HttpRequest.newBuilder(URI.create("http://recognition.image.myqcloud.com/ocr/general"))
                        //  .header("host", "recognition.image.myqcloud.com")
                        .header("content-type", "application/json")
                        .header("authorization", authorization)
                        .POST(HttpRequest.BodyPublishers.ofString(parameter.toJSONString()))
                        .build();

                HttpResponse<String> response;
                try {
                    response = http.send(request, HttpResponse.BodyHandlers.ofString());
                } catch (InterruptedException e) {
                    throw new IOException(e);
                }

                JSONObject responseBody = JSONObject.parseObject(response.body());
                if (Objects.equals(responseBody.getInteger("code"), 0)) {
                    FileWriter fw = new FileWriter(dest.resolve(FilenameUtils.getBaseName(file.getFileName().toString()) + ".json").toFile());
                    JSONWriter writer = new JSONWriter(fw);
                    JSONObject data = responseBody.getJSONObject("data");
                    List<JSONObject> items = data.getJSONArray("items").stream()
                            .map(item -> (JSONObject) item)
                            .filter(item -> {
                                String str = item.getString("itemstring");
                                return !str.equals("编码名称") && !str.equals("编码值");
                            })
                            .collect(Collectors.toList());

                    List<String> strings = items.stream()
                            .map(item -> StringUtils.trim(item.getString("itemstring")))
                            .collect(Collectors.toList());
                    writer.writeObject(strings);
                    writer.flush();
                    writer.close();
                    fw.flush();
                    fw.close();
                }
            }
        }
    }
}
