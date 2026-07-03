Feature: User registration

  Background:
    Given User opens application

  @ui
  @registration
  @positive
  Scenario: Register user
    When User navigates to Login page
    And User completes signup form
    And User completes registration form
    Then Account is created successfully
    When User deletes their account
    Then Account is deleted successfully