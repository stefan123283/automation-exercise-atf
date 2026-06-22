package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountDeletedPage extends Page {

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Deleted!']")
    WebElement accountDeletedHeading;

    public void verifyIfAccountDeletedHeadingIsDisplayed() {
        Assert.assertTrue(accountDeletedHeading.isDisplayed(), "The 'Account Deleted!' heading is not displayed");
    }

    public void clickTheContinueButton() {
        Log.info("Clicking the [Continue] button from the 'Account Deleted' page...");
        continueButton.click();
    }
}
