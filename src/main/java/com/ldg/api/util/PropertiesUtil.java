package com.ldg.api.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties pajaxProperties = new Properties();

    static {
        ClassPathResource pajaxResource = new ClassPathResource("pajax.properties");
        try {
            pajaxProperties.load(pajaxResource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValByKey(String key) {
        return pajaxProperties.getProperty(key);
    }

}
