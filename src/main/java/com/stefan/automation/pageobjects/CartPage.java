package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[text()='Shopping Cart']")
    WebElement shoppingCartNavigationText;

    public void cartPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(shoppingCartNavigationText, "Shopping Cart navigation text"), "Cart page is visible");
    }
}
