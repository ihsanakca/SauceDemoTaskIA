@regression
Feature: Fill Shopping Form test

  Background:
    Given The user is on the login page
    When The user type in valid credentials: "standard_user" and "secret_sauce"
    And The user should be able to add items to cart with item name: "Sauce Labs Fleece Jacket"
    And The user should be able to add items to cart with item name: "Sauce Labs Backpack"
    When The user navigate to your cart page
    When The user navigate to page with related button: "checkout"


  Scenario Outline: Filling Form With More Than One User

    When The user should be able to fill form with: "<firstName>", "<lastName>" and <zipCode>
    And  The user navigate to page with related button: "continue"
    Then The user should be able to see page title: "Checkout: Overview"
    Examples:
      | firstName | lastName | zipCode |
      | Selim     | Gunes    | 34820   |
      | Ali       | Ayik     | 35231   |
      | Ahmet     | Ayik     | 16251   |