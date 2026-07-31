package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Page {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[text()='Checkout']")
    WebElement checkoutNavigationText;

    @FindBy(xpath = "//textarea[//label[text()='If you would like to add a comment about your order, please write it in the field below.']]")
    WebElement commentOrderTextBox;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;

    public void checkoutPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(checkoutNavigationText, "Checkout navigation text"), "Checkout page is visible");
    }

    public void userPlacesTheOrder() {
        Log.info("User places the order");
        ExtentReportManager.addTestStep("User places the order");
        sendKeysToElement(commentOrderTextBox, "Comment order text box", "Order comment");
        clickElement(placeOrderButton, "[Place order] button");
    }
}
