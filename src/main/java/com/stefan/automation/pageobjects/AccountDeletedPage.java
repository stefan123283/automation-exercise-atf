package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountDeletedPage {

    private WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='Account Deleted!']")
    WebElement accountDeletedHeading;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

    public void verifyIfAccountDeletedHeadingIsDisplayed(){
        Assert.assertTrue(accountDeletedHeading.isDisplayed(), "The 'ACCOUNT DELETED!' heading is not displayed");
    }

    public void clickTheContinueButton() {
        Log.info("Clicking the [Continue] button from the 'Account Deleted' page...");
        continueButton.click();
    }
}
