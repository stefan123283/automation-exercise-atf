package com.stefan.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountCreatedPage extends Page{

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    public void verifyIfAccountCreatedHeadingIsDisplayed(){
        Assert.assertTrue(accountCreatedHeading.isDisplayed(), "The 'Account Created!' heading is not displayed");
    }

    public void clickTheContinueButton() {
        continueButton.click();
    }
}
