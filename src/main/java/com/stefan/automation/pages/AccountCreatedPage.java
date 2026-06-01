package com.stefan.automation.pages;

import com.stefan.automation.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {

    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By continueButton = By.xpath("//a[text()='Continue']");

    public void clickTheContinueButton() {
        Log.info("Clicking the [Continue] button from the 'Account Created' page");
        driver.findElement(continueButton).click();
    }
}
