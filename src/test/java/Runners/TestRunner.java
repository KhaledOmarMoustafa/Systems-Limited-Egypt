package Runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/OpenBrowser.feature", // Path to your feature files
        glue = "StepDefinition",// Package where step definitions are located
        tags ="@regression",
        plugin = {"pretty", "html:target/cucumber-reports"}  // Optional: specify report options
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
