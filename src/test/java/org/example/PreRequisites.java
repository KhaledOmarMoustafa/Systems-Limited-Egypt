package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

public class PreRequisites {
    static WebDriver driver;

    public void openBrowser(String browser) {

        FirefoxOptions firefoxOptions;
        EdgeOptions edgeOptions;
        // Initialize WebDriver based on the browser type
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--lang=ar");
                break;
            case "edge":
                driver = new EdgeDriver();
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=ar");
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        String expectedURL = "https://www.google.com/";
        driver.get(expectedURL);

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Browser did not navigate to the expected URL");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
