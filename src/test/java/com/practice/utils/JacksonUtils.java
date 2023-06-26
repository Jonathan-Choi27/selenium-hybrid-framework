package com.practice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deserializeJSON(String filename, Class<T> T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(filename);
        return new ObjectMapper().readValue(is, T);
    }
}
