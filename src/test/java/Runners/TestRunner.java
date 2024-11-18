package Runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/OpenBrowser.feature", // Path to  feature files
        glue = "StepDefinition",// Package where step definitions are located
        tags ="@regression",
        plugin = {"pretty", "html:target/cucumber-reports"}  
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
