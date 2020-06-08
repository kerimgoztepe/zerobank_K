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

  Scenario Outline: Pay operation with <testType>
    And the user enters "<amount>" and "<date>"
    Then the system should display message "Please fill out this field."

    Examples:
      | testType            | amount    | date       |
      | empty amount        |           | 2020-09-10 |
      | empty date          | 2550      |            |
      | alphabetical amount | somewords | 2020-09-10 |
      | special char amount | #$%&      | 2020-09-10 |
      | alphabetical date   | 3750      | somewords  |



  #Scenario: Pay operation with invalid amount values
   # And the user enters the amount box following values
    #  | amount | date       |
     # | .      | 2020-09-10 |
      #| 3000   | .          |
      #| @asd   | 2020-09-10 |
      #| 10200  | @asd       |

    #Then the system should display message "Please fill out this field."