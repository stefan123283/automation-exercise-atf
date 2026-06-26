Feature: User Registration

  @ui
  Scenario: Register_User
    Given Home page is visible successfully
    And [Login] button is clicked
    And New User Signup! is visible
    And Username is entered
    And Email is entered
    And [Signup] button is clicked
    And Enter Account Information is visible
    And Registration form is populated
    And [Create Account] button is clicked
    And Account Created! is visible
    And [Continue] button is clicked
    And Logged in as username is visible
    When [Delete Account] button is clicked
    Then Account Deleted! is displayed
    And [Continue] button is clicked