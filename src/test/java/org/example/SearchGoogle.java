package org.example;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SearchGoogle extends PreRequisites{
    ReadAndWriteData readAndWriteData = new ReadAndWriteData();
    private  ExtentTest logger;

    public SearchGoogle(ExtentTest logger) {
        this.logger = logger;
    }


    public void searchGoogle(String searchKeyWord, String secondPageNumberOfRecord , String thirdPageNumberOfRecords) throws IOException {

        logger.log(Status.INFO, "Starting Google Search for: " + searchKeyWord);





        //sending data from the excel sheet to the element which is the google search bar
        WebElement googleSearchBar = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        googleSearchBar.sendKeys(searchKeyWord);
        googleSearchBar.sendKeys(Keys.ENTER);
        String firstSearchResult = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).getText();

        //making sure that the searchkeyword is equal to the sent search keyword
        Assert.assertEquals(firstSearchResult,searchKeyWord);
        logger.log(Status.PASS, "Search keyword matched the search result");








        int i = 2;
        for (int z = 1; z <= i; z++) {
            //to scroll to the end of the screen
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            WebElement clickSecondPage = driver.findElement(By.xpath("(//td[@class=\"NKTSme\"])["+z+"]"));




            //checking if its the second page then to print the records in it and make sure that its the second by asserting
            if(z==1) {
                String pageText = driver.findElement(By.xpath("//a[@aria-label=\"Page 2\"]")).toString();
                System.out.println(pageText);

                //int startIndex = pageText.indexOf("Page ");
                String pageText2 = pageText.substring(102,103);
                //  String theNumberofThePage = pageText2.substring(1);

                System.out.println("theNumberofThePage:"+pageText2);


                int pageNumber = Integer.parseInt(pageText2);
                clickSecondPage.click();

                //checking if the second page is the one that i clicked
                Assert.assertEquals(pageNumber,2);
                logger.log(Status.PASS, "The Page Number is  : " + pageNumber);

                //storing the search results table in a variable and then checking how many records does it display
                WebElement searchResultsContainer = driver.findElement(By.xpath("//div[@class=\"eqAnXb\"]"));
                List<WebElement> searchResults = searchResultsContainer.findElements(By.xpath("//div[@class=\"MjjYud\"]"));
                int amountOfRecordsPerPAge = searchResults.size();
                secondPageNumberOfRecord = String.valueOf(amountOfRecordsPerPAge);



                int cellNumber = 1;

                //writing the records number in the excel sheet 2nd column
                readAndWriteData.writeData(secondPageNumberOfRecord, cellNumber);

                Assert.assertEquals(amountOfRecordsPerPAge, 10);

                logger.log(Status.PASS, "Second Page - Total records: " + secondPageNumberOfRecord);



                //checking if its the third page then to print the records in it and make sure that its the third by asserting
            }else{
                String pageText = driver.findElement(By.xpath("//a[@aria-label=\"Page 3\"]")).toString();
                System.out.println(pageText);

                //int startIndex = pageText.indexOf("Page ");
                String pageText2 = pageText.substring(102,103);
                //  String theNumberofThePage = pageText2.substring(1);

                System.out.println("theNumberofThePage:"+pageText2);

                int pageNumber = Integer.parseInt(pageText2);

                clickSecondPage.click();

                //checking if the second page is the one that i clicked
                Assert.assertEquals(pageNumber,3);
                logger.log(Status.PASS, "The Page Number is  : " + pageNumber);

                //storing the search results table in a variable and then checking how many records does it display
                WebElement searchResultsContainer = driver.findElement(By.xpath("//div[@class=\"eqAnXb\"]"));
                List<WebElement> searchResults = searchResultsContainer.findElements(By.xpath("//div[@class=\"MjjYud\"]"));
                int amountOfRecordsPerPAge = searchResults.size();
                thirdPageNumberOfRecords = String.valueOf(amountOfRecordsPerPAge);

                int cellNumber = 2;

                //writing the records number in the excel sheet 3rd column
                readAndWriteData.writeData(thirdPageNumberOfRecords, cellNumber);
                Assert.assertEquals(amountOfRecordsPerPAge, 10);
                logger.log(Status.PASS, "Third Page - Total records: " + thirdPageNumberOfRecords);

            }


        }

        //making sure that the number of records in the second page = the number of records in the third page
        Assert.assertEquals(thirdPageNumberOfRecords,secondPageNumberOfRecord);
        logger.log(Status.PASS, "The Number OF The Second Page Records Are Equal To The Number OF The Records OF The Third Page" );


    }
}
