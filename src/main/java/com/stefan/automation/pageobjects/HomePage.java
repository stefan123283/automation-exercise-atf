package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ConfigReaderManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void userOpensApplication() {
        String applicationUrl = ConfigReaderManager.getProperty("applicationUrl");
        Log.info("Accessing the \"" + applicationUrl + "\" url...");
        ExtentReportManager.addTestStep("User opens application");
        driver.get(applicationUrl);
    }

    public void homePageIsVisible() {
        Log.info("Verifying that Home page is visible...");
        homeLink.isDisplayed();
    }

    public void userNavigatesToLoginPage() {
        Log.info("Navigating to Login page...");
        ExtentReportManager.addTestStep("User navigates to Login page");
        loginButton.click();
    }

    public void userDeletesTheirAccount() {
        Log.info("Clicking [Delete Account] button...");
        ExtentReportManager.addTestStep("User deletes their account");
        deleteAccountButton.click();
    }

}
