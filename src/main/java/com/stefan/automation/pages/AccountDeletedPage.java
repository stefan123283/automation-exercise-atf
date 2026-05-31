package com.stefan.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage {

    private WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By continueButton = By.xpath("//a[text()='Continue']");

    public void clickTheContinueButton() {
        driver.findElement(continueButton).click();
    }
}
