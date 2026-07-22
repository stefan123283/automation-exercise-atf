package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    private static final String APPLICATION_URL = ConfigReaderManager.getProperty("applicationUrl");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    WebElement homePageHeading;

    public void userOpensApplication() {
        Log.info("Opening application URL");
        ExtentReportManager.addTestStep("User opens application");
        driver.get(APPLICATION_URL);
    }

    public void homePageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(homePageHeading, "Home page heading"), "Home page is visible");
    }

    public void userNavigatesToLoginPage() {
        Log.info("Navigating to Login page");
        ExtentReportManager.addTestStep("User navigates to Login page");
        clickElement(loginButton, "[Login] button");
    }

    public void userDeletesTheirAccount() {
        Log.info("Deleting created account");
        ExtentReportManager.addTestStep("User deletes their account");
        clickElement(deleteAccountButton, "[Delete] button");
        closePopUpAddIfPresent();
    }

    public void userLogsOut() {
        Log.info("Logging out");
        ExtentReportManager.addTestStep("User logs out");
        clickElement(logoutButton, "[Logout] button");
    }

    public void userIsLoggedInSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(loggedInAsUserLink, "Logged in as user link"), "User is logged in successfully");
    }

    public void userNavigatesToContactUSPage() {
        Log.info("Navigating to Contact us page");
        ExtentReportManager.addTestStep("User navigates to Contact us page");
        clickElement(contactUsLink, "[Contact us] button");
    }

    public void userNavigatesToTestCasesPage() {
        Log.info("Navigating to Test Cases page");
        ExtentReportManager.addTestStep("User navigates to Test Cases page");
        clickElement(testCasesButton, "[Test Cases] button");
        closePopUpAddIfPresent();
    }

}
