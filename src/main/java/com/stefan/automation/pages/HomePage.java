package com.stefan.automation.pages;

import com.stefan.automation.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By homeLink = By.xpath("//a[contains(text(), 'Home')]");

    private By loginLink = By.xpath("//a[contains(text(), 'Login')]");

    private By deleteAccountButton = By.xpath("//a[contains(text(), 'Delete Account')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        Log.info("Clicking the [Signup / Login] button from the Home page");
        driver.findElement(loginLink).click();
    }

    public void clickTheDeleteAccountButton() {
        Log.info("Clicking the [Delete Account] button from the 'Home' page");
        driver.findElement(deleteAccountButton).click();
    }

}
