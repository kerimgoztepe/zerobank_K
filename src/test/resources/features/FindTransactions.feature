Feature: Find Transactions in Account Activity

  Background:
    Given the user is logged in
    And the user clicks "Account Activity" tab
    And the user accesses the "Find Transactions" sub tab

  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06" and clicks search
    Then the results should be displayed between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06" and clicks search
    Then the results should not contain the date "2012-09-01"


  Scenario: Search description
    When the user enters description "ONLINE" and clicks search
    Then the results should contain "ONLINE"
    When the user enters description "OFFICE" and clicks search
    Then the results should contain "OFFICE"
    But the results should not contain "ONLINE"

  Scenario: Search description case insensitive
    When the user enters description "ONLINE" and clicks search
    Then the results should contain "ONLINE"
    When the user enters description "online" and clicks search
    Then the results should contain "ONLINE"


  Scenario: Type
    When the user clicks search
    Then the results should contain a result under Deposit
    Then the results should contain a result under Withdrawal
    When the user selects type "Deposit"
    And the user clicks search
    Then the results should contain a result under Deposit
    When the user selects type "Withdrawal"
    And the user clicks search
    Then the results should contain a result under Deposit





