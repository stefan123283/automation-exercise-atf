package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
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

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody//tr[@id='product-1']//td[@class='cart_quantity']//button")
    WebElement firstProductQuantityBox;

    public void cartPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(shoppingCartNavigationText, "Shopping Cart navigation text"), "Cart page is visible");
    }

    public void bothProductsAreAddedToCart() {
        List<WebElement> productsList = driver.findElements(By.xpath("//table[@id='cart_info_table']//tbody//tr[contains(@id, 'product')]"));
        Log.debug("Product list contains " + productsList.size() + " elements");
        AssertManager.assertTrue(productsList.size() == 2, "Both products are added to cart");
    }

    public void productIsDisplayedWithExactQuantity() {
        AssertManager.assertTrue((getElementAttributeValue(firstProductQuantityBox, "First product quantity box", "innerText")).equals("4"), "Product is displayed with exact quantity");
    }
}
