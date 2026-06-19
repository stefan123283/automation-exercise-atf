package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginLink;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsUsernameLink;

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        Log.info("Clicking the [Signup / Login] button from the Home page...");
        loginLink.click();
    }

    public void clickTheDeleteAccountButton() {
        deleteAccountButton.click();
    }

    public void verifyIfHomePageIsDisplayed(){
        Assert.assertTrue(homeLink.isDisplayed(), "The 'Home' page is not displayed");
    }

    public void verifyIfLoggedInAsUsernameLinkIsDisplayed(){
        Assert.assertTrue(loggedInAsUsernameLink.isDisplayed(), "The 'Logged in as username' link is not displayed");
    }

}
