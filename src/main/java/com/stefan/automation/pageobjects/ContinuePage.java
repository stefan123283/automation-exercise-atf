package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContinuePage extends Page {

    public ContinuePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    @FindBy(xpath = "//h2[.='Account Deleted!']")
    WebElement accountDeletedHeading;

    @FindBy(id = "aswift_2")
    WebElement adFrame;

    @FindBy(xpath = "//div[text()='Close']")
    WebElement closeAddButton;

    public void verifyAccountCreatedIsVisible() {
        Log.info("Verifying that \"Account Created!\" is visible...");
        ExtentReportManager.addTestStep("\"Account Created!\" is visible");
        accountCreatedHeading.isDisplayed();
    }

    public void verifyAccountDeletedIsVisible() {
        Log.info("Verifying that \"Account Deleted!\" is visible...");
        ExtentReportManager.addTestStep("\"Account Deleted!\" is visible");
        Assertions.assertTrue(accountDeletedHeading.isDisplayed(), "The \"Account Deleted!\" heading is displayed");
    }

    public void clickTheContinueButton() {
        Log.info("Clicking the [Continue] button...");
        ExtentReportManager.addTestStep("The [Continue] button is clicked");
        continueButton.click();
        //TODO Add explicit wait
        try {
            if (adFrame.isDisplayed()) {
                Log.info("Switching to the ad frame and closing the ad...");
                switchToFrame(adFrame);
                closeAddButton.click();
                switchToDefaultContent();
            }
        } catch (NoSuchElementException e) {
            Log.info("The ad is not visible");
        }
    }

}
