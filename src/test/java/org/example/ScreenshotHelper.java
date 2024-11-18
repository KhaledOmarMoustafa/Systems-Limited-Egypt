package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Base64;

public class ScreenshotHelper {
    private WebDriver driver;

    public ScreenshotHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(ExtentTest testLogger, String screenshotName) {
        if (driver != null) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Encode screenshot as Base64 to put directly in the report
                String base64Screenshot = Base64.getEncoder().encodeToString(ts.getScreenshotAs(OutputType.BYTES));
                testLogger.addScreenCaptureFromBase64String(base64Screenshot, screenshotName);
                testLogger.log(Status.INFO, "Screenshot captured: " + screenshotName);
            } catch (Exception e) {
                testLogger.log(Status.WARNING, "Unable to capture screenshot: " + e.getMessage());
            }
        } else {
            testLogger.log(Status.WARNING, "Driver is null; cannot capture screenshot");
        }
    }
}
