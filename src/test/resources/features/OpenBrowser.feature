@regression
Feature: User searches for a given keyword on Google

  Scenario Outline: User searches Google
    Given user opens the "chrome"
    And take Screen shot
    When tries to search for a "<searchKeyWord>" and store the records "<secondPageNumberOfRecord>" of the second page and the "<thirdPageNumberOfRecords>" third page and stores them in an excel sheet
    Then user closes the browser

    Examples:
      | searchKeyWord       | secondPageNumberOfRecord | thirdPageNumberOfRecords |
      | SYSTEMS EGYPT       | 10                       | 10                       |