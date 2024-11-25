/*
 * Copyright 2022 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.amazonaws.kafka.config.providers;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import com.amazonaws.kafka.config.providers.common.CommonConfigUtils;

public class S3ImportConfig extends AbstractConfig{

    public static final String LOCAL_DIR = "local_dir";
    private static final String LOCAL_DIR_DOC = 
            "Local directory to store imported from S3 files. " + 
            "If not provided, temporary directory defined in OS will be used.)";

    public static final String SHOULD_OVERWRITE_EXISTING_FILE = "should_overwrite_existing";
    private static final String SHOULD_OVERWRITE_EXISTING_FILE_DOC =
            "Whether to overwrite a file which was already imported from S3. " +
                    "If not provided or 'false' and the file already exists, it will not be copied over." +
                    "If the files exists and the value is 'true', it will be copied and overwritten)";

    public S3ImportConfig(Map<?, ?> originals) {
        super(config(), originals);
    }

    private static ConfigDef config() {
        return new ConfigDef(CommonConfigUtils.COMMON_CONFIG)
                .define(
                        LOCAL_DIR,
                        ConfigDef.Type.STRING,
                        null,
                        ConfigDef.Importance.HIGH,
                        LOCAL_DIR_DOC
                        )
                .define(
                        SHOULD_OVERWRITE_EXISTING_FILE,
                        ConfigDef.Type.BOOLEAN,
                        false,
                        ConfigDef.Importance.MEDIUM,
                        SHOULD_OVERWRITE_EXISTING_FILE_DOC
                )
                ;
    }
}