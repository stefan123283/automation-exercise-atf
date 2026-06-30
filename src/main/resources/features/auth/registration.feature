Feature: User Registration

  Background:
    Given The "https://automationexercise.com" url is accessed

  @ui
  Scenario Outline: Register user with "<username>" username and "<email>" email
    And Home page is visible successfully
    And [Login] button is clicked
    And New User Signup! is visible
    And The New User Signup form is populated with the following data:
      | <username> |
      | <email>    |
    And [Signup] button is clicked
    And Enter Account Information is visible
    And The Account Information form is populated
    And [Create Account] button is clicked
    And Account Created! is visible
    And [Continue] button is clicked
    And Logged in as username is visible
    When [Delete Account] button is clicked
    Then Account Deleted! is visible
    And [Continue] button is clicked
    Examples:
      | username | email                 |
      | user1    | user1@randomemail.com |
      | user2    | user2@randomemail.com |