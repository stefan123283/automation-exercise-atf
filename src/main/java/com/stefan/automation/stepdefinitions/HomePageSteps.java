package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("Home page is visible successfully")
    public void verifyHomePageIsVisibleSuccessfully() {
        ExtentReportManager.addTestStep("Verify that the Home page is visible successfully");
        Log.info("Verifying if the Home page is visible successfully...");
        homePage.verifyHomePageIsVisible();
    }

    @And("[Login] button is clicked")
    public void clickOnLoginButton() {
        ExtentReportManager.addTestStep("Click the [Login] button");
        Log.info("Clicking the [Login] button...");
        homePage.clickOnLoginButton();
    }

    @And("Logged in as username is visible")
    public void verifyLoggedInAsUsernameLinkIsDisplayed() {
        ExtentReportManager.addTestStep("Verify that the \"Logged in as username\" is visible");
        Log.info("Verifying that the \"Logged in as username\" is visible...");
        homePage.verifyLoggedInAsUsernameLinkIsDisplayed();
    }

    @When("[Delete Account] button is clicked")
    public void clickTheDeleteAccountButton() {
        ExtentReportManager.addTestStep("Click the [Delete Account] button");
        Log.info("Clicking the [Delete Account] button...");
        homePage.clickTheDeleteAccountButton();
    }

}
