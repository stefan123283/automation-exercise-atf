Feature: Authentification functionality

  @api
  @authentification
  @postToVerifyLoginWithoutEmailParameter
  Scenario: POST To verify login without email parameter
    When User prepares the "password" request parameter with "password" value
    And User sends a "POST" request to the "https://automationexercise.com/api/verifyLogin" url
    Then Response code is 400
    And Response message is "Bad request, email or password parameter is missing in POST request."

  @api
  @authentification
  @deleteToVerifyLogin
  Scenario: DELETE To verify login
    When User sends a "DELETE" request to the "https://automationexercise.com/api/verifyLogin" url
    Then Response code is 405
    And Response message is "This request method is not supported."

  @api
  @authentification
  @postToVerifyLoginWithInvalidDetails
  Scenario: POST to verify login with invalid details
    Given User prepares the "email" request parameter with "invalid email" value
    And User prepares the "password" request parameter with "invalid password" value
    When User sends a "POST" request to the "https://automationexercise.com/api/verifyLogin" url
    Then Response code is 404
    And Response message is "User not found!"

  @api
  @authentification
  @postToVerifyLoginWithValidDetails
  Scenario: POST To verify login with valid details
    Given User data is generated
    And User prepares request parameters for registration
    When User sends a "POST" request to the "https://automationexercise.com/api/createAccount" url
    Then Response code is 201
    When User prepares the "email" request parameter with "valid email" value
    And User prepares the "password" request parameter with "valid password" value
    And User sends a "POST" request to the "https://automationexercise.com/api/verifyLogin" url
    Then Response code is 200
    And Response message is "User exists!"

