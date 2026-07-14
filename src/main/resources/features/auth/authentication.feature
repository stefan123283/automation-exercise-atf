Feature: User authentification

  Background:
    Given User opens application
    And User data is generated

  @ui
  @authentification
  @positive
  Scenario: Login yser with correct email and password
    When User navigates to Login page
    And User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User logs out
    Then Login page is displayed
    When User completes login form
    Then User is logged in successfully
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @authentification
  @negative
  Scenario: Login user with incorrect email and password
    And User navigates to Login page
    When User completes login form
    Then Authentification is unsuccessfully
