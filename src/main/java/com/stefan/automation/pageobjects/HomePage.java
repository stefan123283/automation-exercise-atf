package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsUsernameLink;

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePageIsVisible() {
        Log.info("Verifying that Home page is visible successfully...");
        ExtentReportManager.addTestStep("Home page is visible successfully");
        homeLink.isDisplayed();
    }

    public void clickOnLoginButton() {
        Log.info("Clicking the [Login] button...");
        ExtentReportManager.addTestStep("The [Login] button is clicked");
        loginButton.click();
    }

    public void clickTheDeleteAccountButton() {
        Log.info("Clicking the [Delete Account] button...");
        ExtentReportManager.addTestStep("The [Delete Account] button is clicked");
        deleteAccountButton.click();
    }

    public void verifyLoggedInAsUsernameLinkIsVisible() {
        Log.info("Verifying that \"Logged in as username\" is visible...");
        ExtentReportManager.addTestStep("\"Logged in as username\" is visible");
        loggedInAsUsernameLink.isDisplayed();
    }

}
