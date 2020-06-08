@login
Feature: Login

  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user logs in with valid credentials
    Then  The page title should be "Zero - Account Summary"


  Scenario Outline: Login with invalid credentials <testtype>
    When the user logs in with invalid "<username>" or "<password>"
    Then  the system should display error message "Login and/or password are wrong."
    Examples:
      | username      | password      | testtype       |
      |               | password      | empty username |
      | username      |               | empty password |
      | wrongusername | password      | wrong username |
      | username      | wrongpassword | wrong password |
      | username      | wrongpassword | wrong password |
      |               |               | both empty     |