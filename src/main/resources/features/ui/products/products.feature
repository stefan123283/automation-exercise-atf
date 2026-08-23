Feature: Product browsing

  Background:
    When User opens application

  @ui
  @products
  @verifyAllProductsAndProductDetailPage
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

  @ui
  @products
  @viewCategoryProducts
  Scenario: View category products
    Then Home page is visible
    When User navigates to Dress category page
    Then Dress category page is visible
    When User navigates to Tshirts category page
    Then Tshirts category page is visible

  @ui
  @products
  @view&CartBrandProducts
  Scenario: View & cart brand products
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User navigates to Polo brand page
    Then Polo brand page is visible
    When User navigates to H&M brand page
    Then H&M brand page is visible

  @ui
  @products
  @addReviewOnProduct
  Scenario: Add review on product
    Then Home page is visible
    When User navigates to All Products page
    Then All Products page is visible
    When User clicks on [View Product] button of first product
    Then Product detail page is visible
    When User submits product review
    Then The review is submitted successfully
