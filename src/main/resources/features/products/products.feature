Feature: Product browsing

  Background:
    When User opens application

  @ui
  @products
  @productDetailPage
  Scenario: Verify all products and product detail page
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User clicks on [View Product] button of first product
    Then Product detail page is visible

  @ui
  @products
  @searchProduct
  Scenario: Search product
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User search a specific product
    Then The searched product is visible

