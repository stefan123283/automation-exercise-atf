package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.RegistrationPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class RegistrationPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @And("User completes registration form")
    public void userCompletesRegistrationForm() {
        registrationPage.userCompletesRegistrationForm();
    }

}
