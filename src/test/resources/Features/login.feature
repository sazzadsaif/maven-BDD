@Login_test
Feature: Test login functionalities

  Background:
    Given a user is on the login page

  @positive_test
  Scenario: Check login is successful with valid credentials
    When user enters user name "Sazzad" and password "12345"
    And click on login button
    Then user is navigated to home page

  @dataDriven_test @positive_test
  Scenario Outline: Check login is successful with valid credentials
    When user enters user name "<userName>" and password "<password>"
    And click on login button
    Then user is navigated to home page

    Examples:
    |userName|password|
    |Sazzad  |12345   |
    |Rifat   |12345   |
    |Robert  |12345   |

  @dataDriven_test @positive_test
  Scenario: Check login is successful using data table
    When user click on login button upon entering credentials
      |userName|password|
      |Sazzad  |12345   |
      |Rifat   |12345   |
    Then user is navigated to the home page after data table

  @negative_test
  Scenario: Check login is successful with invalid credentials
    When user enters user name "Sazzad" and password "11111"
    And click on login button
    Then user is failed to login



