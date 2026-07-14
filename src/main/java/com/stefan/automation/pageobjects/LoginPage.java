package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
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
        AssertManager.assertTrue(checkIfElementIsVisible(loginButton, "[Login] button"), "Login page is displayed");
    }

    public void userCompletesSignupForm(String username, String email) {
        ExtentReportManager.addTestStep("User completes signup form");
        Log.info("Completing signup form");
        sendKeysToElement(usernameTextBox, "Username text box", username);
        sendKeysToElement(signUpEmailTextBox, "Signup email text box", email);
        clickElement(signupButton, "[Signup] button");
        Log.info("Signup form completed");
    }

    public void userCompletesLoginForm(String email, String password) {
        ExtentReportManager.addTestStep("User completes login form");
        Log.info("Completing login form");
        sendKeysToElement(loginEmailTextBox, "Email Address text box", email);
        sendKeysToElement(passwordTextBox, "Password text box", password);
        clickElement(loginButton, "[Login] button");
    }

    public void loginErrorMessageIsDisplayed(){
        AssertManager.assertTrue(checkIfElementIsVisible(loginErrorMessage, "Login error message"), "Authentification is unsuccessfully");
    }

    public void signupErrorMessageIsDisplayed(){
        AssertManager.assertTrue(checkIfElementIsVisible(signupErrorMessage, "Signup error message"), "Registration is unsuccessfully");
    }

}
