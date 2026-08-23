Feature: User account functionality

  Background:
    Given User data is generated

  @api
  @user-account
  @postToCreateRegisterUserAccount
  Scenario: POST to create/register user account
    And User prepares request parameters for registration
    When User sends a "POST" request to the "https://automationexercise.com/api/createAccount" url
    Then Response code is 201
    And Response message is "User created!"

  @api
  @user-account
  @deleteMethodToDeleteUserAccount
  Scenario: DELETE method to delete user account
    And User prepares request parameters for registration
    When User sends a "POST" request to the "https://automationexercise.com/api/createAccount" url
    Then Response code is 201
    When User prepares the "email" request parameter with "valid email" value
    And User prepares the "password" request parameter with "valid password" value
    And User sends a "DELETE" request to the "https://automationexercise.com/api/deleteAccount" url
    Then Response code is 200
    And Response message is "Account deleted!"

  @api
  @user-account
  @putMethodToUpdateUserAccount
  Scenario: PUT method to update user account
    And User prepares request parameters for registration
    When User sends a "POST" request to the "https://automationexercise.com/api/createAccount" url
    Then Response code is 201
    When User sends a "PUT" request to the "https://automationexercise.com/api/updateAccount" url
    Then Response code is 200
    And Response message is "User updated!"

  @api
  @user-account
  @getUserAccountDetailByEmail
  Scenario: GET user account detail by email
    And User prepares request parameters for registration
    When User sends a "POST" request to the "https://automationexercise.com/api/createAccount" url
    Then Response code is 201
    When User prepares the "email" request parameter with "valid email" value
    And User sends a "GET" request to the "https://automationexercise.com/api/getUserDetailByEmail" url
    Then Response code is 200
