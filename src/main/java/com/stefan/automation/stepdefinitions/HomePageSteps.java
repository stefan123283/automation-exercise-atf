package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("User opens application")
    public void userOpensApplication() {
        homePage.userOpensApplication();
        homePage.homePageIsVisible();
    }

    @When("User navigates to Login page")
    public void loginPageIsAccessed() {
        homePage.userNavigatesToLoginPage();
    }

    @When("User deletes their account")
    public void userDeletesTheirAccount() {
        homePage.userDeletesTheirAccount();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        homePage.userIsLoggedInSuccessfully();
    }

    @When("User logs out")
    public void userLogsOut() {
        homePage.userLogsOut();
    }

}
