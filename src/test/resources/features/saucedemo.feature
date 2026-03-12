Feature: Saucedemo Purchase
  As a Saucedemo user
  I want to log in and make purchases
  In order to buy products

  Background:
    Given the actor is on the login page
    And the actor closes any browser notification

  @login
  Scenario: Successful login with valid user
    When the actor logs in with valid credentials
    Then the actor should see the product catalog

  @login
  Scenario: Failed login with invalid user
    When the actor tries to log in with user "invalid_user" and password "wrongpass"
    Then should see an error message indicating incorrect credentials

  @cart
  Scenario: Add a product to cart
    Given the actor has logged in as standard user
    When adds the product "Sauce Labs Backpack" to the cart
    Then the cart should show 1 product

  @checkout
  Scenario: Complete a purchase with one product in cart
    Given the actor has logged in as standard user
    And has the product "Sauce Labs Backpack" in the cart
    When proceeds to checkout and completes shipping information
    And finishes the purchase
    Then should see a purchase confirmation message

  @remove
  Scenario: Add multiple products, remove one, and complete purchase
    Given the actor has logged in as standard user
    When adds the products "Sauce Labs Backpack" and "Sauce Labs Bike Light" to the cart
    And removes the product "Sauce Labs Bike Light" from the cart
    And proceeds to checkout and completes shipping information
    And finishes the purchase
    Then should see a purchase confirmation message