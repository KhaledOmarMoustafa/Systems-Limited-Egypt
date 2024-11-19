**Keyword Search Automation Project**

Project Overview
This project automates the process of searching for a specific keyword on Google, navigating through search result pages, counting the result records on both the second and third pages, and comparing these counts. The goal is to verify that the number of records on the second page is consistent with the number of records on the third page.

Functional Flow
Keyword Search: The automation starts by searching for a specific keyword on Google.
Second Page Navigation: After retrieving the search results from the first page, the automation navigates to the second page of the search results.
Count Records on the Second Page: It counts the number of result records present on the second search results page.
Third Page Navigation: Next, the automation navigates to the third page of the search results.
Count Records on the Third Page: It counts the number of result records on the third search results page.
Comparison: The automation compares the count of result records between the second and third pages to verify if they are the same.
Tools and Frameworks Used


**This project is built using the following tools and frameworks:**

*Selenium: For browser automation, used to open the browser, perform searches, and interact with web pages.
*Cucumber: For Behavior Driven Development (BDD), allowing feature files and step definitions to be written in natural language.
*TestNG: For running and managing tests. TestNG provides annotations for setup and teardown of tests, as well as grouping and parameterization.
*Data-Driven Testing (DDT): The test data is driven by an Excel sheet, allowing for easy updates and modifications to the data being tested.
*Extent Reports: For generating detailed, visually appealing test reports with logs of the test execution.
*Loggers: Used for logging the test execution and capturing relevant information for debugging and troubleshooting.
*Page Object Model (POM): The Page Object Model design pattern is implemented to separate the logic of interacting with web pages and the test execution. This ensures better maintainability and scalability of the tests.
*Maven: A build automation tool used to manage dependencies and build lifecycle for the project.
*Object-Oriented Programming (OOP) Principles: The code follows OOP principles like encapsulation, inheritance, and polymorphism for better structure and reusability.
*Java: The programming language used to write the test automation code.
*Screenshots: Screenshots are captured at different stages of the test execution to provide a visual record of the process and capture errors if any occur.

*StepDefinition: Contains the Java methods that define the behavior described in the feature files.
*PageObject: Contains page classes representing web pages, with methods for interacting with elements on each page.
*TestRunner: The main class to trigger the Cucumber tests and integrate with TestNG.
Util: Contains utility classes like logging and screenshot helpers.
*DataProviders: Provides test data from Excel sheets using the Data-Driven Testing (DDT) approach.
Test Execution

**How to Run the Project**
Pre-Requisites
Java Development Kit (JDK): Ensure JDK 8 or later is installed.
Maven: Install Maven for dependency management.
IDE: Use an IDE like IntelliJ IDEA or Eclipse for editing and running the project.
WebDriver Binaries: Ensure the appropriate WebDriver executables (e.g., ChromeDriver, GeckoDriver, EdgeDriver) are available in your system's PATH or configured in the code.
Excel File: Verify that the input Excel file (New Microsoft Excel Worksheet.xlsx) exists at the specified path and contains valid data.
Steps to Run

*Clone the Repository:*
git clone https://github.com/KhaledOmarMoustafa/Systems-Limited-Egypt.git
cd Systems-Limited-Egypt


*Configure the Browser:*
Open the OpenBrowser.feature file.
Set the browser parameter to the desired browser (e.g., chrome, firefox, edge).

*Run the Tests:*
Using the IDE:
Open the project in your IDE.
Run the TestNG.xml file by click the run in the top and i set it to locate the testng.xml path .

*Using Maven:*
mvn test

*Test Execution Logs:*
Logs will be displayed in the console for tracking the progress.
Screenshots will be saved in the specified directory.
Accessing the Reports
Extent Report
Location of the Report:
After test execution, the Extent Report is generated as an HTML file named extent-report.html in the project root directory.
How to View the Report:
Open the extent-report.html file in any web browser.
Navigate through the test execution summary, detailed logs, screenshots, and pass/fail status of each test step.


**How the Project Works**
*Data-Driven Testing:*

Test data (search keywords) is read from the Excel file.
The number of records on the second and third pages is written back to the Excel file for verification.

*Search Automation:*

The browser navigates to Google.
The specified keyword is entered into the search bar.
Results on the second and third pages are retrieved and counted.

*Validation:*

The number of records on the second page is compared to the third page.
TestNG assertions are used to ensure correctness.

*Screenshots:*

Screenshots are taken at various stages, such as after opening the browser, performing the search, and navigating through pages.

*Reporting:*

The Extent Report provides a comprehensive view of test execution, including logs, screenshots, and assertions.
