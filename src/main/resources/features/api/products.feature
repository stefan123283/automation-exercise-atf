Feature: Products functionality

  @api
  @products
  @getAllProductsList
  Scenario: GET all products list
    When User sends a "GET" request to the "https://automationexercise.com/api/productsList" url
    Then Response code is 200

  @api
  @products
  @postToAllProductsList
  Scenario: POST to all products list
    When User sends a "POST" request to the "https://automationexercise.com/api/productsList" url
    Then Response code is 405
    And Response message is "This request method is not supported."

  @api
  @products
  @postToSearchProduct
  Scenario: POST to search product
    Given User prepares the "search_product" request parameter with "top" value
    When User sends a "POST" request to the "https://automationexercise.com/api/searchProduct" url
    Then Response code is 200

  @api
  @products
  @postToSearchProductWithoutSearchProductParameter
  Scenario: POST To search product without search_product parameter
    When User sends a "POST" request to the "https://automationexercise.com/api/searchProduct" url
    Then Response code is 400
    And Response message is "Bad request, search_product parameter is missing in POST request."