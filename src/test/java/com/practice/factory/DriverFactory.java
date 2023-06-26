package com.practice.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            default -> throw new IllegalArgumentException("Invalid Browser: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}