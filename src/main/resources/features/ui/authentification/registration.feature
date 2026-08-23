Feature: User registration

  Background:
    Given User opens application
    And User data is generated

  @ui
  @authentification
  @registerUser
  Scenario: Register user
    When User navigates to Login page
    And User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User deletes their account
    Then Account is deleted successfully

  @ui
  @authentification
  @registerUserWithExistingEmail
  Scenario: Register user with existing email
    When User navigates to Login page
    And User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User logs out
    Then Login page is displayed
    When User completes signup form
    Then Registration is unsuccessfully
    When User completes login form
    Then User is logged in successfully
    When User deletes their account
    Then Account is deleted successfully
