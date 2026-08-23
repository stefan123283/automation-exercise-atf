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

  @ui
  @common
  @VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality
  Scenario: Verify scroll up using 'Arrow' button and scroll down functionality
    Then Home page is visible
    When User scrolls to bottom of page
    And User clicks the scroll up arrow
    Then Page is scrolled up

  @ui
  @common
  @verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality
  Scenario: Verify scroll up without 'Arrow' button and scroll down functionality
    Then Home page is visible
    When User scrolls to bottom of page
    And User scrolls to top of page
    Then Page is scrolled up