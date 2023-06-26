package com.practice.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            properties.load(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found at " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file " + filePath, e);
        }

        return properties;
    }
}
