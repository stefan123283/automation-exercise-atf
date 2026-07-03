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

    public void accountIsCreatedSuccessfully() {
        Log.info("Verifying that account is created successfully...");
        ExtentReportManager.addTestStep("Account is created successfully");
        Assertions.assertTrue(accountCreatedHeading.isDisplayed(), "Account is created successfully");
        userClicksContinueButton();
    }

    public void accountIsDeletedSuccessfully() {
        Log.info("Verifying that account is deleted successfully...");
        ExtentReportManager.addTestStep("Account is deleted successfully");
        Assertions.assertTrue(accountDeletedHeading.isDisplayed(), "Account is deleted successfully");
    }

    public void userClicksContinueButton() {
        Log.info("Clicking [Continue] button...");
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
            Log.info("No ads are displayed");
        }
    }

}
