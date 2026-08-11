package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    WebElement loginEmailTextBox;

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(name = "name")
    WebElement usernameTextBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailTextBox;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement loginErrorMessage;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    WebElement signupErrorMessage;

    public void loginPageIsDisplayed(){
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(loginButton, "[Login] button"), "Login page is displayed");
    }

    public void userCompletesSignupForm(String username, String email) {
        ExtentReportManager.addTestStep("User completes signup form");
        Log.info("Completing signup form");
        KeyboardManager.enterValueIntoElement(usernameTextBox, "Username text box", username);
        KeyboardManager.enterValueIntoElement(signUpEmailTextBox, "Signup email text box", email);
        clickElement(signupButton, "[Signup] button");
        Log.info("Signup form completed");
    }

    public void userCompletesLoginForm(String email, String password) {
        ExtentReportManager.addTestStep("User completes login form");
        Log.info("Completing login form");
        KeyboardManager.enterValueIntoElement(loginEmailTextBox, "Email Address text box", email);
        KeyboardManager.enterValueIntoElement(passwordTextBox, "Password text box", password);
        clickElement(loginButton, "[Login] button");
    }

    public void loginErrorMessageIsDisplayed(){
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(loginErrorMessage, "Login error message"), "Authentification is unsuccessfully");
    }

    public void signupErrorMessageIsDisplayed(){
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(signupErrorMessage, "Signup error message"), "Registration is unsuccessfully");
    }

}
