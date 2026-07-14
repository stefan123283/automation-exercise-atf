package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContinuePage extends Page {

    public ContinuePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    @FindBy(xpath = "//h2[.='Account Deleted!']")
    WebElement accountDeletedHeading;

    @FindBy(xpath = "//div[text()='Close']")
    WebElement closeAddButton;

    List<WebElement> adsFrame;

    public void accountIsCreatedSuccessfully() {
        AssertManager.assertTrue(checkIfElementIsVisible(accountCreatedHeading, "Account Created heading"), "Account created successfully");
        clickElement(continueButton, "[Continue] button");
        closePopUpAddIfPresent();
    }

    public void accountIsDeletedSuccessfully() {
        AssertManager.assertTrue(checkIfElementIsVisible(accountDeletedHeading, "Account Deleted heading"), "Account deleted successfully");
        clickElement(continueButton, "[Continue] button");
        closePopUpAddIfPresent();
    }

    public void closePopUpAddIfPresent() {
        adsFrame = driver.findElements(By.id("aswift_2"));
        if (!adsFrame.isEmpty()) {
            switchToFrame(adsFrame.getFirst(), "Advertisements frame");
            clickElement(closeAddButton, "[Close add] button");
            switchToDefaultContent();
        }
    }

}
