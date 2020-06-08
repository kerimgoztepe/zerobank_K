
Feature: Navigating	to specific	accounts in	Accounts Activity

  Scenario Outline:    <ColumnName>    account	redirect
    Given   the user is logged in
    When    the	user clicks	on "<ColumnName>" link on the Account Summary page
    Then    the	"Account Activity" page should be displayed
    And     Account	drop down should have "<ColumnName>" selected
    Examples:
      | ColumnName  |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |
