package com.stefan.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsUsernameLink;

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyHomePageIsVisible() {
        homeLink.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void clickTheDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void verifyLoggedInAsUsernameLinkIsDisplayed() {
        loggedInAsUsernameLink.isDisplayed();
    }

}
