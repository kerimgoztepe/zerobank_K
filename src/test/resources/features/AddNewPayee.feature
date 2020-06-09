Feature: Add new payee under pay bills

  Scenario: Add a new payee
    Given the user is logged in
    And the user clicks "Pay Bills" tab
    And the user accesses the "Add New Payee" sub tab
    When creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100	Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then the system should display "The new payee The Law Offices of Hyde, Price & Scharks was successfully created."

