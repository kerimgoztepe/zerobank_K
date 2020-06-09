Feature: Purchase Foreign Currency
  Background:
    Given the user is logged in
    And the user clicks "Pay Bills" tab
    And the user accesses the "Purchase Foreign Currency" sub tab

  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  Scenario: Error message for not selecting currency
    When the user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @wip
  Scenario: Error message for not entering value
    When the user tries to calculate cost without entering value
    Then error message should be displayed