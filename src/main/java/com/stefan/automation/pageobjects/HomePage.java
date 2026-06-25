package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;

public class HomePage extends Page {

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsUsernameLink;

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyIfHomePageIsDisplayed() {
        Assertions.assertTrue(homeLink.isDisplayed(), "The \"Home\" page is displayed");
    }

    public void navigateToLoginPage() {
        Log.info("Navigating to Login page...");
        loginLink.click();
    }

    public void clickTheDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void verifyIfLoggedInAsUsernameLinkIsDisplayed() {
        Assertions.assertTrue(loggedInAsUsernameLink.isDisplayed(), "The \"Logged in as username\" link is displayed");
    }

}
