package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ConfigReaderManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private static final String APPLICATION_URL = ConfigReaderManager.getProperty("applicationUrl");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void userOpensApplication() {
        Log.info("Opening application URL");
        ExtentReportManager.addTestStep("User opens application");
        driver.get(APPLICATION_URL);
    }

    public void homePageIsVisible() {
        checkIfElementIsVisible(homeLink, "Home link");
        Log.info("Home page loaded successfully");
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
    }

    public void userLogsOut() {
        Log.info("Logging out");
        ExtentReportManager.addTestStep("User logs out");
        clickElement(logoutButton, "[Logout] button");
    }

    public void userIsLoggedInSuccessfully() {
        AssertManager.assertTrue(checkIfElementIsVisible(loggedInAsUserLink, "Logged in as user link"), "User is logged in successfully");
    }

}
