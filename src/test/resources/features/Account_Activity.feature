@wip
Feature: Account Activity

  Background:
    Given the user is on the login page
    And the user logs in with valid credentials
    When the user clicks "Account Activity" tab

  Scenario: Account activity title
    Then  The page title should be "Zero - Account Activity"

  Scenario: Default option of account dropdown
    Then the account dropdown default option should be "Savings"

  Scenario: Account dropdown options
    Then the account dropdown should have
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions table column names
    Then the transaction table column names should be
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |



