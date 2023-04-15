Feature: Success Shopping Feature

  Background:
    Given The user is on the login page
    When The user type in valid credentials: "standard_user" and "secret_sauce"
    Then The user should be able to see page title: "Products"


  Scenario: Positive Success Shopping E2E Test
    When The user should be able to sort items order type: "Price (high to low)"
    And The user should be able to add items to cart with item name: "Sauce Labs Fleece Jacket"
    And The user should be able to add items to cart with item name: "Sauce Labs Backpack"
    And The user should be able to add items to cart with item name: "Sauce Labs Bolt T-Shirt"
    And The user should be able to add items to cart with item name: "Sauce Labs Bike Light"
    Then The number on the basket icon should show the added item number
    When The user navigate to your cart page
    Then The user should be able to see page title: "Your Cart"
    And The user should see the items on the page that added before
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Backpack      |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Bike Light    |
    When The user should be able to delete items from cart with item name :"Sauce Labs Fleece Jacket"
    When The user should be able to delete items from cart with item name :"Sauce Labs Backpack"
    Then The number on the basket icon should show the added item number
    When The user navigate to page with related button: "checkout"
    Then The user should be able to see page title: "Checkout: Your Information"
    When The user should be able to fill form with: "Selim", "Gezer" and "35400"
    And  The user navigate to page with related button: "continue"
    Then The user should be able to see page title: "Checkout: Overview"
    When The user should be able to verify total price and number of items
    And  The user navigate to page with related button: "finish"
    Then The user should be able to see page title: "Checkout: Complete!"
    And The user should take success shopping message: "Thank you for your order!"
