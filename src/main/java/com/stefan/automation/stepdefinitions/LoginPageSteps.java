package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @And("New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        loginPage.verifyNewUserSignupIsVisible();
    }

    @And("The New User Signup form is populated with the following data:")
    public void populateTheNewUserSignupForm(List<String> credentialsList) {
        loginPage.populateTheNewUserSignupForm(credentialsList.get(0), credentialsList.get(1));
    }

    @And("[Signup] button is clicked")
    public void clickTheSignupButton() {
        loginPage.clickTheSignupButton();
    }

    @And("Enter Account Information is visible")
    public void verifyEnterAccountInformationIsVisible() {
        loginPage.verifyEnterAccountInformationIsVisible();
    }

    @And("The Account Information form is populated")
    public void populateTheRegistrationForm() {
        loginPage.populateTheAccountInformationForm(FakeDataManager.generateRandomPassword(), FakeDataManager.generateRandomDay(), FakeDataManager.generateRandomMonth(), FakeDataManager.generateRandomYear(), FakeDataManager.generateRandomFirstName(), FakeDataManager.generateRandomLastName(), FakeDataManager.generateRandomCompany(), FakeDataManager.generateRandomStreetAddress(),
                FakeDataManager.generateRandomState(), FakeDataManager.generateRandomCity(), FakeDataManager.generateRandomZipCode(), FakeDataManager.generateRandomMobileNumber());
    }

    @And("[Create Account] button is clicked")
    public void clickTheCreateAccountButton() {
        loginPage.clickTheCreateAccountButton();
    }

}
