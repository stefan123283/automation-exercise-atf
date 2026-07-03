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
        String username = FakeDataManager.generateRandomUsername();
        Log.info("Entering \"" + username + "\" value in the \"Name\" field");
        usernameTextBox.sendKeys(username);
        String email = FakeDataManager.generateRandomEmail();
        Log.info("Entering \"" + email + "\" value in the \"Email Address\" field");
        signUpEmailTextBox.sendKeys(email);
        Log.info("Clicking [Signup] button...");
        signupButton.click();
    }

}
