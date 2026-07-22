Feature: Home page functionality

  Background:
    When User opens application

  @ui
  @common
  @testCasesPage
  Scenario: Test Cases page
    Then Home page is visible
    When User navigates to Test Cases page
    Then Test Cases page is visible