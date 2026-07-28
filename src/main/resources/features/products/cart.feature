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
    And Product is displayed with exact quantity

