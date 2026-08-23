Feature: Shopping cart

  Background:
    When User opens application

  @ui
  @products
  @addProductsInCart
  Scenario: Add products in cart
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User adds first two products to cart
    And User clicks [View Cart] button
    Then Cart page is visible
    And Both products are added to cart

  @ui
  @products
  @verifyProductQuantityInCart
  Scenario: Verify product quantity in cart
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User clicks on [View Product] button of first product
    Then Product detail page is visible
    When User increases product quantity to four
    And User clicks [Add to cart] button
    And User clicks [View Cart] button
    Then Cart page is visible
    And Product is displayed in Cart page with "4" quantity

  @ui
  @products
  @removeProductsFromCart
  Scenario: Remove products from cart
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User clicks on [View Product] button of first product
    Then Product detail page is visible
    When User clicks [Add to cart] button
    And User clicks [View Cart] button
    Then Cart page is visible
    When User removes product from cart
    Then Product is removed from cart

  @ui
  @products
  @searchProductsAndVerifyCartAfterLogin
  Scenario: Search products and verify cart after login
    And User data is generated
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User search a specific product
    Then The searched product is visible
    When User clicks on [View Product] button of first product
    Then Product detail page is visible
    When User increases product quantity to four
    And User clicks [Add to cart] button
    And User clicks [View Cart] button
    Then Product is displayed in Cart page with "4" quantity
    When User navigates to Login page
    And User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User logs out
    Then Login page is displayed
    When User completes login form
    Then User is logged in successfully
    When User navigates to Cart page
    Then Product is displayed in Cart page with "4" quantity
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @products
  @addToCartFromRecommendedItems
  Scenario: Add to cart from recommended items
    Then Home page is visible
    When User scrolls to bottom of page
    And User adds to cart a recommended product
    And User clicks [View Cart] button
    Then Product is displayed in Cart page with "1" quantity
