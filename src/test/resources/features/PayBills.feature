Feature: Pay Bills

  Background:
    Given the user is on the login page
    And the user logs in with valid credentials
    When the user clicks "Pay Bills" tab

  Scenario: Checking the page title
    Then The page title should be "Zero - Pay Bills"


  Scenario: Successful pay operation
    And the user fills the necessary places and clicks pay
    Then the system should display "The payment was successfully submitted."

  Scenario: Pay operation with an empty amount value
    And the user leaves empty the amount box
    Then the system should display message "Please fill out this field."

  Scenario: Pay operation with an empty date value
    And the user leaves empty the date box
    Then the system should display message "Please fill out this field."

  @wip
  Scenario: Pay operation with invalid amount value
    And the user enters alphabetical characters to amountbox
    Then the system should display message "Please fill out this field."

  @wip
  Scenario: Pay operation with invalid amount value
    And the user enters special characters to amountbox
    Then the system should display message "Please fill out this field."
  @wip
  Scenario: Pay operation with invalid date value
    And the user enters alphabetical characters to date box
    Then the system should display message "Please fill out this field."


  #Scenario: Pay operation with invalid amount values
   # And the user enters the amount box following values
    #  | amount | date       |
     # | .      | 2020-09-10 |
      #| 3000   | .          |
      #| @asd   | 2020-09-10 |
      #| 10200  | @asd       |

    #Then the system should display message "Please fill out this field."