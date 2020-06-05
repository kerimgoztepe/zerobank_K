@login
Feature: Login

  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user logs in with valid credentials
    Then  The page title should be "Zero - Account Summary"

  Scenario: Login with invalid credentials
    When the user logs in with blank username or password
    Then  the system should display error message "Login and/or password are wrong."

  Scenario: Login with invalid credentials
    When the user logs in with "John" "Doe"
    Then  the system should display error message "Login and/or password are wrong."