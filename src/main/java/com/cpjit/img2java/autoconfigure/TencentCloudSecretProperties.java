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
package com.cpjit.img2java.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yonghuan
 */
@ConfigurationProperties("tencent.cloud.secret")
public class TencentCloudSecretProperties {

    private long appId;
    private String secretId;
    private String secretKey;

    public long getAppId() {
        return appId;
    }

    public TencentCloudSecretProperties setAppId(long appId) {
        this.appId = appId;
        return this;
    }

    public String getSecretId() {
        return secretId;
    }

    public TencentCloudSecretProperties setSecretId(String secretId) {
        this.secretId = secretId;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public TencentCloudSecretProperties setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }
}
