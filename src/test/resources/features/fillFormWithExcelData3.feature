Feature: Fill Shopping Form with Excel Data 3

  Background:
    Given The user is on the login page
    When The user type in valid credentials: "standard_user" and "secret_sauce"
    And The user should be able to add items to cart with item name: "Sauce Labs Fleece Jacket"
    And The user should be able to add items to cart with item name: "Sauce Labs Backpack"
    When The user navigate to your cart page
    When The user navigate to page with related button: "checkout"

  @wip
  Scenario Outline: Filling form excel data scenario 3

    When The user should be able to fill form with path: "src/test/resources/automationCucumber.xlsx", "<sheetName>" and <rowNumber>
    And  The user navigate to page with related button: "continue"
    Then The user should be able to see page title: "Checkout: Overview"
    Examples:
      | sheetName | rowNumber |
      | userInfo  | 0         |
      | userInfo  | 1         |
      | userInfo2 | 0         |
      | userInfo2 | 1         |
      | userInfo2 | 2         |
