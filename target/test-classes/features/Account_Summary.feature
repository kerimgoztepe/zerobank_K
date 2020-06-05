@account_summary
Feature: Account Summary

  Background:
    Given the user is on the login page
    And the user logs in with valid credentials

  Scenario: Account Summary Page and Account Types
    Then  The page title should be "Zero - Account Summary"

  Scenario: Account Types
    Then the system should display following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Account Columns
    Then the system credit account table must have
      | Account     |
      | Credit Card |
      | Balance     |