package com.practice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/cucumber.html"},
        features = "src/test/resources/com.practice/add-to-cart.feature",
        glue = "com.practice",
        snippets = CAMELCASE,
        monochrome = true,
        dryRun = false
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
