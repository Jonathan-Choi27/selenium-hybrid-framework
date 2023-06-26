package com.practice.types;

import com.practice.objects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {
    @ParameterType(".*")
    public Product product(String name) {
        return new Product(name.replace("\"", ""));
    }
}
