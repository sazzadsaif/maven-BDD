Feature: Mortgage Calculator
  @CalculateApr
  Scenario: Calculate Real APR Rate
    Given user is in the mortgage calculator home page
    And user navigate to the Real Apr page
    When user on the calculate button upon entering the data
    |HomePrice|DownPayment|InterestRate|
    |200000   |15000      |3           |
    Then the real apr rate is "3.130%"