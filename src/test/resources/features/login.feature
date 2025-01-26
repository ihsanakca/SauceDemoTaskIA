@regression
Feature: Login Functionality


  Scenario: Success Login
    Given The user is on the login page
    When The user type in valid credentials: "standard_user" and "secret_sauce"
    Then The user should be able to see page title: "Products"