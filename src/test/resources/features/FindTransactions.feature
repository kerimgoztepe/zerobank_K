Feature: Find Transactions in Account Activity
  @wip
  Scenario: Search date range
    Given the user is logged in
    And the user clicks "Account Activity" tab
    And the user accesses the "Find Transactions" sub tab
    When the user enters date range from "2012-09-01" to "2012-09-06" and clicks search
    Then the results should be displayed between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date

