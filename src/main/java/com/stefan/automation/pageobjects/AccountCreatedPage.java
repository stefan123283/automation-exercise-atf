package com.stefan.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page{

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    public void verifyAccountCreatedHeadingIsDisplayed(){
        accountCreatedHeading.isDisplayed();
    }

    public void clickTheContinueButton() {
        continueButton.click();
    }
}
