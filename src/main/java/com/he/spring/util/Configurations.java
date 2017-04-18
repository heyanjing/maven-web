package com.he.spring.util;

import java.io.File;
import java.net.URL;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;

/**
 * 加载属性文件
 * http://commons.apache.org/proper/commons-configuration/userguide_v1.10/howto_properties.html#Properties_files
 * If you do not specify an absolute path, the file will be searched automatically in the following locations:
 * in the current directory
 * in the user home directory
 * in the classpath
 */
public class Configurations {

    private static final Logger LOGGER = Logs.getLogger(Configurations.class);

    public static PropertiesConfiguration newPropertiesConfiguration(Object obj) {
        org.apache.commons.configuration2.builder.fluent.Configurations configs = new org.apache.commons.configuration2.builder.fluent.Configurations();
        PropertiesConfiguration properties = null;
        try {
            if (obj instanceof String) {
                properties = configs.properties((String) obj);
            } else if (obj instanceof File) {
                properties = configs.properties((File) obj);
            } else if (obj instanceof URL) {
                properties = configs.properties((URL) obj);
            } else {
                throw Exceptions.newRuntimeException("该方法不支持类型：" + obj.getClass());
            }
        } catch (ConfigurationException e) {
            LOGGER.warn("未找到或加载属性文件失败！", e.getMessage());
            throw Exceptions.newRuntimeException(e);
        }
        return properties;
    }
}
