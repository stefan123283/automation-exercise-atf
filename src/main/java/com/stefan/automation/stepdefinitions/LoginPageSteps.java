package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("New User Signup! is visible")
    public void verifyNewUserSignupHeadingIsDisplayed() {
        ExtentReportManager.addTestStep("Verify that the \"New User Signup!\" heading is visible");
        Log.info("Verifying that the \"New User Signup!\" heading is visible...");
        loginPage.verifyNewUserSignupHeadingIsDisplayed();
    }

    @And("Username is entered")
    public void enterUsername() {
        ExtentReportManager.addTestStep("Enter the username");
        Log.info("Entering the username...");
        loginPage.enterUsername("user1");
    }

    @And("Email is entered")
    public void enterEmail() {
        ExtentReportManager.addTestStep("Enter the email");
        Log.info("Entering the email...");
        loginPage.enterEmail("user1@randomemail.com");
    }

    @And("[Signup] button is clicked")
    public void clickTheSignupButton() {
        ExtentReportManager.addTestStep("Click the [Signup] button");
        Log.info("Clicking the [Signup] button...");
        loginPage.clickTheSignupButton();
    }

    @And("Enter Account Information is visible")
    public void verifyEnterAccountInformationHeadingIsDisplayed() {
        ExtentReportManager.addTestStep("Verify that the \"Enter Account Information\" is visible");
        Log.info("Verifying that the \"Enter Account Information\" is visible...");
        loginPage.verifyEnterAccountInformationHeadingIsDisplayed();
    }

    @And("Registration form is populated")
    public void populateTheRegistrationForm() {
        ExtentReportManager.addTestStep("Populate the registration form");
        Log.info("Populating the registration form...");
        loginPage.populateTheRegistrationForm(FakeDataManager.generateRandomPassword(), FakeDataManager.generateRandomDay(), FakeDataManager.generateRandomMonth(), FakeDataManager.generateRandomYear(), FakeDataManager.generateRandomFirstName(), FakeDataManager.generateRandomLastName(), FakeDataManager.generateRandomCompany(), FakeDataManager.generateRandomStreetAddress(),
                FakeDataManager.generateRandomState(), FakeDataManager.generateRandomCity(), FakeDataManager.generateRandomZipCode(), FakeDataManager.generateRandomMobileNumber());
    }

    @And("[Create Account] button is clicked")
    public void clickTheCreateAccountButton() {
        ExtentReportManager.addTestStep("Click the [Create Account] button");
        Log.info("Clicking the [Create Account] button...");
        loginPage.clickTheCreateAccountButton();
    }

}
