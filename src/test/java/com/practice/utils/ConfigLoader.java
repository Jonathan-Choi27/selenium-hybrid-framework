package com.practice.utils;

import com.practice.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final Properties properties;

    private ConfigLoader() {
        String env = System.getProperty("env", EnvType.STAGE.toString());
        switch (EnvType.valueOf(env)) {
            case PROD -> properties = PropertyUtils.loadProperties("src/test/resources/prod-config.properties");
            case STAGE -> properties = PropertyUtils.loadProperties("src/test/resources/stage-config.properties");
            default -> throw new IllegalStateException("Invalid Env: " + env);
        }
    }

    public static synchronized ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the stg_config.properties file");
    }
}
