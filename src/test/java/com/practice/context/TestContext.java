package com.practice.context;

import com.practice.objects.BillingDetails;
import com.practice.objects.Cookies;
import com.practice.objects.Product;
import com.practice.objects.ProductList;
import com.practice.utils.JacksonUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;
    public Product product;
    public ProductList productList = new ProductList();

    public TestContext() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
        productList.addAllProducts(JacksonUtils.deserializeJSON("products.json", Product[].class));
    }
}
