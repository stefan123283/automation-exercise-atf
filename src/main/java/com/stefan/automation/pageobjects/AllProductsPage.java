package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends Page {

    public AllProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allProductsPageHeading;

    @FindBy(xpath = "//a[contains(text(), 'View Product')]")
    WebElement viewProductButton;

    @FindBy(id = "search_product")
    WebElement searchProductTextBox;

    @FindBy(id = "submit_search")
    WebElement productSearchButton;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedProductsHeading;

    @FindBy(xpath = "(//a[text()='Add to cart'])[1]")
    WebElement addToCartFirstProductButton;

    @FindBy(xpath = "(//a[text()='Add to cart'])[3]")
    WebElement addToCartSecondProductButton;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[contains(., 'View Cart')]")
    WebElement viewCartButton;

    public void allProductsPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(allProductsPageHeading, "All Products page heading"), "All Products page is visible");
    }

    public void clickOnViewProductButtonOfFirstProduct() {
        ExtentReportManager.addTestStep("User clicks on [View Product] button of first product");
        clickElement(viewProductButton, "[View Product] button");
        closePopUpAddIfPresent();
    }

    public void userSearchASpecificProduct() {
        Log.info("User search a specific product");
        ExtentReportManager.addTestStep("User search a specific product");
        sendKeysToElement(searchProductTextBox, "Search product text box", "Men Tshirt");
        clickElement(productSearchButton, "Product search button");
    }

    public void theSearchedProductIsVisible() {
        ExplicitWaitManager.waitUntilElementIsVisible(searchedProductsHeading, "Searched products heading");
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(viewProductButton, "[View Product] button"), "The searched product is visible");
    }

    public void userAddsFirstTwoProductsToCart() {
        clickElement(addToCartFirstProductButton, "[Add to cart] first product product");
        clickElement(continueShoppingButton, "[Continue Shopping] button");
        clickElement(addToCartSecondProductButton, "[Add to cart] second product product");
    }

    public void userClickViewCartButton() {
        clickElement(viewCartButton, "[View Cart] button");
    }

}
