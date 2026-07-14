package com.stefan.automation.stepdefinitions;

import com.stefan.automation.context.TestContext;
import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);
    private TestContext testContext;

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {
        loginPage.loginPageIsDisplayed();
    }

    public LoginPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("User completes signup form")
    public void userCompletesSignupForm() {
        loginPage.userCompletesSignupForm(testContext.getUser().getUsername(), testContext.getUser().getEmail());
    }

    @And("User completes login form")
    public void userCompletesLoginForm() {
        loginPage.userCompletesLoginForm(testContext.getUser().getEmail(), testContext.getUser().getPassword());
    }

    @Then("Authentification is unsuccessfully")
    public void loginErrorMessageIsDisplayed() {
        loginPage.loginErrorMessageIsDisplayed();
    }

    @Then("Registration is unsuccessfully")
    public void signupErrorMessageIsDisplayed(){
        loginPage.signupErrorMessageIsDisplayed();
    }

}
