package com.practice.hooks;

import com.practice.context.TestContext;
import com.practice.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseHooks {
    private WebDriver driver;
    private final TestContext context;

    public BaseHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void before(Scenario scenario) {
        System.out.println("Before Thread Id: " + Thread.currentThread().getId() + "," +
                "Scenario Name: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After
    public void takeScreenShotsOnStepFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("After Thread Id: " + Thread.currentThread().getId() + "," +
                "Scenario Name: " + scenario.getName());
        driver.quit();
    }
}
