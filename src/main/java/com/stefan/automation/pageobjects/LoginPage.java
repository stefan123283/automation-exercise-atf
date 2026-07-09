package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.FakeDataManager;
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

    public void userCompletesSignupForm() {
        ExtentReportManager.addTestStep("User completes signup form");
        Log.info("Completing signup form");
        sendKeysToElement(usernameTextBox, "Username text box", FakeDataManager.generateRandomUsername());
        sendKeysToElement(signUpEmailTextBox, "Signup email text box", FakeDataManager.generateRandomEmail());
        clickElement(signupButton, "[Signup] button");
        Log.info("Signup form completed");
    }

}
