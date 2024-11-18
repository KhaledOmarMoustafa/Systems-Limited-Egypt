package StepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PreRequisites;
import org.example.ReadAndWriteData;
import org.example.ScreenshotHelper;
import org.example.SearchGoogle;
import org.testng.annotations.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class Runner {
    static ExtentReports extentReports;
    static ExtentTest testLogger;

    PreRequisites preRequisites = new PreRequisites();
    ScreenshotHelper screenshotHelper;
    SearchGoogle searchGoogle;
    ReadAndWriteData readAndWriteData = new ReadAndWriteData();

    @BeforeClass
    @Given("user opens the \"(.*)\"$")
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) throws InterruptedException {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        // Initialize ScreenshotHelper with WebDriver from PreRequisites
        preRequisites.openBrowser(browser);
        screenshotHelper = new ScreenshotHelper(PreRequisites.getDriver());
        testLogger = extentReports.createTest("Setup");
    }

    @Test(priority = 1)
    @And("take Screen shot")
    public void openBrowser() {
        testLogger = extentReports.createTest("Open Browser");
        try {
            testLogger.log(Status.PASS, "Browser opened successfully");
            screenshotHelper.captureScreenshot(testLogger, "BrowserOpenedSuccessfully" );

        } catch (Exception e) {
            testLogger.log(Status.FAIL, "Failed to open browser: " + e.getMessage());
            screenshotHelper.captureScreenshot(testLogger, "OpenBrowserError");
        }
    }

    @Test(priority = 2, dataProvider = "test_Data")
    @When("^tries to search for a \"(.*)\" and store the records \"(.*)\" of the second page and the \"(.*)\" third page and stores them in an excel sheet$")
    public void searchGoogle(String searchKeyWord, String secondPageNumberOfRecord, String thirdPageNumberOfRecords) throws IOException {
        testLogger = extentReports.createTest("Search Test");
        searchGoogle = new SearchGoogle(testLogger);
        try {
            searchGoogle.searchGoogle(searchKeyWord, secondPageNumberOfRecord, thirdPageNumberOfRecords);
            testLogger.log(Status.PASS, "Search test executed successfully");
            screenshotHelper.captureScreenshot(testLogger, "SearchSuccess");
        } catch (Exception e) {
            testLogger.log(Status.FAIL, "Search test failed: " + e.getMessage());
            screenshotHelper.captureScreenshot(testLogger, "SearchError");
        }
        extentReports.flush();
    }

    @DataProvider(name = "test_Data")
    public String[][] test_Data() throws IOException, InvalidFormatException {
        return readAndWriteData.readData();
    }

    @Test(priority = 3)
    @Then("user closes the browser")
    public void closeBrowser() {
        testLogger = extentReports.createTest("Close Browser");
        try {
            screenshotHelper.captureScreenshot(testLogger, "BeforeClosingBrowser");
            preRequisites.closeBrowser();
            testLogger.log(Status.PASS, "Browser closed successfully");
        } catch (Exception e) {
            testLogger.log(Status.FAIL, "Failed to close browser: " + e.getMessage());
            screenshotHelper.captureScreenshot(testLogger, "CloseBrowserError");
        }
        extentReports.flush();


    }
}
