package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
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

    @FindBy(xpath = "//h2[contains(., 'Dress Products')]")
    WebElement dressCategoryHeading;

    @FindBy(xpath = "//h2[contains(., 'Tshirts Products')]")
    WebElement tShirtsCategoryHeading;

    @FindBy(xpath = "//a[contains(.,'Polo')]")
    WebElement poloBrand;

    @FindBy(xpath = "//h2[contains(., 'Polo Products')]")
    WebElement poloBrandHeading;

    @FindBy(xpath = "//a[contains(.,'H&M')]")
    WebElement hAndMBrand;

    @FindBy(xpath = "//h2[contains(., 'H&M Products')]")
    WebElement hAndMBrandHeading;

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
        KeyboardManager.enterValueIntoElement(searchProductTextBox, "Search product text box", "Men Tshirt");
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

    public void dressCategoryPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(dressCategoryHeading, "Dress category heading"), "Dress category page is visible");
    }

    public void tShirtsCategoryPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(tShirtsCategoryHeading, "Tshirts category heading"), "Tshirts category page is visible");
    }

    public void userNavigatesToPoloBrandPage() {
        Log.info("Navigating to Polo brand page");
        ExtentReportManager.addTestStep("User navigates to Polo brand page");
        clickElement(poloBrand, "Polo brand link");
    }

    public void poloBrandPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(poloBrandHeading, "Polo brand heading"), "Polo brand page is visible");
    }

    public void userNavigatesToHAndMBrandPage() {
        Log.info("Navigating to H&M brand page");
        ExtentReportManager.addTestStep("User navigates to H&M brand page");
        clickElement(hAndMBrand, "H&M brand link");
    }

    public void hAndMBrandPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(hAndMBrandHeading, "H&M brand heading"), "H&M brand page is visible");
    }

}
