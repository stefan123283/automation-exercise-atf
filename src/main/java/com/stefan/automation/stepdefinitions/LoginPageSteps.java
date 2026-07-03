package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("User completes signup form")
    public void userCompletesSignupForm() {
        loginPage.userCompletesSignupForm();
    }

}
