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
import org.springframework.core.io.Resource;

/**
 * @author yonghuan
 */
@ConfigurationProperties("baidu.translate")
public class BaiduTranslateProperties {

    private String appId;
    private String securityKey;
    /**
     * 是否自动删除来源文件
     */
    private boolean autoClear;
    private boolean ignoreError = true;
    private Resource sourceDirectory;
    private Resource targetDirectory;

    public String getAppId() {
        return appId;
    }

    public BaiduTranslateProperties setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public BaiduTranslateProperties setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
        return this;
    }

    public boolean isAutoClear() {
        return autoClear;
    }

    public BaiduTranslateProperties setAutoClear(boolean autoClear) {
        this.autoClear = autoClear;
        return this;
    }

    public boolean isIgnoreError() {
        return ignoreError;
    }

    public BaiduTranslateProperties setIgnoreError(boolean ignoreError) {
        this.ignoreError = ignoreError;
        return this;
    }

    public Resource getSourceDirectory() {
        return sourceDirectory;
    }

    public BaiduTranslateProperties setSourceDirectory(Resource sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
        return this;
    }

    public Resource getTargetDirectory() {
        return targetDirectory;
    }

    public BaiduTranslateProperties setTargetDirectory(Resource targetDirectory) {
        this.targetDirectory = targetDirectory;
        return this;
    }
}
