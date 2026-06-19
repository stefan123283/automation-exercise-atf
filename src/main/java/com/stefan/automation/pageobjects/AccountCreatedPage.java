package com.stefan.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountCreatedPage {

    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='Account Created!']")
    WebElement accountCreatedHeading;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

    public void verifyIfAccountCreatedHeadingIsDisplayed(){
        Assert.assertTrue(accountCreatedHeading.isDisplayed(), "The 'ACCOUNT CREATED!' heading is not displayed");
    }

    public void clickTheContinueButton() {
        continueButton.click();
    }
}
