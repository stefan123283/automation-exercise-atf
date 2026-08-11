Feature: Checkout and orders

  Background:
    When User opens application
    And User data is generated

  @ui
  @orders
  @placeOrderRegisterWhileCheckout
  Scenario: Place order: register while checkout
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User adds first two products to cart
    And User clicks [View Cart] button
    Then Cart page is visible
    And Both products are added to cart
    When User clicks on [Proceed to Checkout] button
    And User clicks on [Register Login] button
    Then Login page is displayed
    When User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User navigates to Cart page
    Then Cart page is visible
    When User clicks on [Proceed to Checkout] button
    Then Checkout page is visible
    When User places the order
    Then Payment page is visible
    When User populates the payment form
    Then Order is placed successfully
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @orders
  @placeOrderRegisterBeforeCheckout
  Scenario: Place order: register before checkout
    Then Home page is visible
    When User navigates to Login page
    Then Login page is displayed
    When User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User navigates to All Products page
    Then All Products page is visible
    When User adds first two products to cart
    And User clicks [View Cart] button
    Then Cart page is visible
    When User clicks on [Proceed to Checkout] button
    Then Checkout page is visible
    When User places the order
    Then Payment page is visible
    When User populates the payment form
    Then Order is placed successfully
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @orders
  @placeOrderLoginBeforeCheckout
  Scenario: Place order: login before checkout
    Then Home page is visible
    When User navigates to Login page
    Then Login page is displayed
    When User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User logs out
    Then Login page is displayed
    When User completes login form
    Then User is logged in successfully
    When User navigates to All Products page
    Then All Products page is visible
    When User adds first two products to cart
    And User clicks [View Cart] button
    Then Cart page is visible
    When User clicks on [Proceed to Checkout] button
    Then Checkout page is visible
    When User places the order
    Then Payment page is visible
    When User populates the payment form
    Then Order is placed successfully
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @orders
  @verifyAddressDetailsInCheckoutPage
  Scenario: Verify address details in checkout page
    Then Home page is visible
    When User navigates to Login page
    And User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User navigates to All Products page
    Then All Products page is visible
    When User adds first two products to cart
    And User clicks [View Cart] button
    Then Cart page is visible
    When User clicks on [Proceed to Checkout] button
    Then The delivery address information is correct
    And The billing address information is correct
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @orders
  @downloadInvoiceAfterPurchaseOrder
  Scenario: Download invoice after purchase order
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User adds first two products to cart
    And User clicks [View Cart] button
    Then Cart page is visible
    When User clicks on [Proceed to Checkout] button
    And User clicks on [Register Login] button
    Then Login page is displayed
    When User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User navigates to Cart page
    Then Cart page is visible
    When User clicks on [Proceed to Checkout] button
    Then Checkout page is visible
    When User places the order
    Then Payment page is visible
    When User populates the payment form
    Then Order is placed successfully
    When User downloads the invoice
    And User deletes their account
    Then Account is deleted successfully
    And Invoice is downloaded successfully