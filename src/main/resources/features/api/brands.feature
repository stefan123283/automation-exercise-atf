Feature: Brands functionality

  @api
  @brands
  @getAllBrandsList
  Scenario: GET all brands list
    When User sends a "GET" request to the "https://automationexercise.com/api/brandsList" url
    Then Response code is 200

  @api
  @brands
  @putToAllBrandsList
  Scenario: PUT to all brands list
    When User sends a "PUT" request to the "https://automationexercise.com/api/brandsList" url
    Then Response code is 405
    And Response message is "This request method is not supported."