Feature: Contact us form

  Background:
    When User opens application

  @ui
  @common
  @contactUsForm
  Scenario: Contact us form
    Then Home page is visible
    When User navigates to Contact us page
    And User completes Contact us form
    Then Contact us form is submitted successfully
    When User navigates to Home page
    Then Home page is visible