Keyword Search Automation Project

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


*To run the tests, the project uses TestNG with Cucumber. The test can be executed through Maven using the following command:

"mvn test"
This will trigger the execution of Cucumber feature files through the TestRunner class, and generate an Extent Report summarizing the test results.
