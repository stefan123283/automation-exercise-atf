package com.stefan.automation.pageobjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page{

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    public void verifyIfAccountCreatedHeadingIsDisplayed(){
        Assertions.assertTrue(accountCreatedHeading.isDisplayed(), "The \"Account Created!\" heading is displayed");
    }

    public void clickTheContinueButton() {
        continueButton.click();
    }
}
