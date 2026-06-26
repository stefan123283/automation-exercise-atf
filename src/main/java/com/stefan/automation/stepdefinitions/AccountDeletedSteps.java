package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.pageobjects.AccountDeletedPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class AccountDeletedSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);

    @Then("Account Deleted! is displayed")
    public void verifyAccountDeletedHeadingIsDisplayed() {
        ExtentReportManager.addTestStep("Verify that the \"Account Deleted!\" is visible");
        Log.info("Verifying that the \"Account Deleted!\" is visible...");
        accountDeletedPage.verifyAccountDeletedHeadingIsDisplayed();
    }

}
