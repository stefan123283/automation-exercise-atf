Feature: User authentification

  Background:
    When User opens application
    And User data is generated

  @ui
  @authentification
  @loginUserWithCorrectEmailAndPassword
  Scenario: Login user with correct email and password
    Then Home page is visible
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
  @loginUserWithIncorrectEmailAndPassword
  Scenario: Login user with incorrect email and password
    Then Home page is visible
    When User navigates to Login page
    And User completes login form
    Then Authentification is unsuccessfully
