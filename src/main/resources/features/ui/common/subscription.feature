Feature: Subscription

  Background:
    When User opens application

  @ui
  @common
  @verifySubscriptionInHomePage
  Scenario: Verify subscription in home page
    Then Home page is visible
    When User scrolls to bottom of page
    Then Subscription section is visible
    When User submits subscription email address
    Then User is subscribed successfully

  @ui
  @common
  @verifySubscriptionInCartPage
  Scenario: Verify subscription in cart page
    Then Home page is visible
    When User navigates to Cart page
    Then Cart page is visible
    When User scrolls to bottom of page
    Then Subscription section is visible
    When User submits subscription email address
    Then User is subscribed successfully