package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.pageobjects.AccountCreatedPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

    @And("Account Created! is visible")
    public void verifyAccountCreatedHeadingIsDisplayed() {
        ExtentReportManager.addTestStep("Verify that the \"Account Created!\" is visible");
        Log.info("Verifying that the \"Account Created!\" is visible...");
        accountCreatedPage.verifyAccountCreatedHeadingIsDisplayed();
    }

    @And("[Continue] button is clicked")
    public void clickTheContinueButton() {
        ExtentReportManager.addTestStep("Click the [Continue] button");
        Log.info("Clicking the [Continue] button...");
        accountCreatedPage.clickTheContinueButton();
    }
}
