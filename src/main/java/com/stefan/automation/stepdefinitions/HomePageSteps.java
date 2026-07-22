package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @When("User opens application")
    public void userOpensApplication() {
        homePage.userOpensApplication();
    }

    @Then("Home page is visible")
    public void homePageIsVisible() {
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

    @When("User navigates to Contact us page")
    public void userNavigatesToContactUSPage() {
        homePage.userNavigatesToContactUSPage();
    }

    @When("User navigates to Test Cases page")
    public void userNavigatesToTestCasesPage() {
        homePage.userNavigatesToTestCasesPage();
    }

}
