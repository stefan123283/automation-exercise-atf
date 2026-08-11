package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[text()='Shopping Cart']")
    WebElement shoppingCartNavigationText;

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody//tr[contains(@id, 'product-')]//td[@class='cart_quantity']//button")
    WebElement productQuantityBox;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//a[contains(., 'Register / Login')]")
    WebElement registerLoginButton;

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody//tr[@id='product-1']//td[@class='cart_delete']//a")
    WebElement removeFirstProductButton;

    @FindBy(xpath = "//p[contains(., 'Cart is empty! Click here to buy products.')]")
    WebElement cartIsEmptyMessage;

    public void cartPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(shoppingCartNavigationText, "Shopping Cart navigation text"), "Cart page is visible");
    }

    public void bothProductsAreAddedToCart() {
        List<WebElement> productsList = driver.findElements(By.xpath("//table[@id='cart_info_table']//tbody//tr[contains(@id, 'product')]"));
        Log.debug("Product list contains " + productsList.size() + " elements");
        AssertManager.assertTrue(productsList.size() == 2, "Both products are added to cart");
    }

    public void productIsDisplayedWithExactQuantity(String quantity) {
        AssertManager.assertTrue((getElementAttributeValue(productQuantityBox, "First product quantity box", "innerText")).equals(quantity), "Product is displayed in Cart page with " + quantity + " quantity");
    }

    public void userClickOnProceedToCheckoutButton() {
        Log.info("Clicking on [Proceed to Checkout] button");
        ExtentReportManager.addTestStep("User clicks on [Proceed to Checkout] button");
        clickElement(proceedToCheckoutButton, "[Proceed to Checkout] button");
    }

    public void userClickOnRegisterLoginButton() {
        Log.info("Clicking on [Register / Login] button");
        ExtentReportManager.addTestStep("User clicks on [Register / Login] button");
        clickElement(registerLoginButton, "[Register / Login] button");
    }

    public void userRemovesProductFromCart() {
        Log.info("Removing product from cart");
        ExtentReportManager.addTestStep("User removes product from cart");
        clickElement(removeFirstProductButton, "[X] button");
    }

    public void productIsRemovedFromCart() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(cartIsEmptyMessage, "Cart is empty message"), "Product is removed from cart");
    }
}
