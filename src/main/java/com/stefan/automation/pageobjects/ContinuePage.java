package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
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

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    WebElement orderPlacedSuccessfullyMessage;

    public void accountIsCreatedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(accountCreatedHeading, "Account Created heading"), "Account created successfully");
        clickElement(continueButton, "[Continue] button");
        closePopUpAddIfPresent();
    }

    public void accountIsDeletedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(accountDeletedHeading, "Account Deleted heading"), "Account deleted successfully");
    }

    public void orderPlacedSuccessfully() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(orderPlacedSuccessfullyMessage, "Order placed successfully message"), "Order is placed successfully");
    }

}
