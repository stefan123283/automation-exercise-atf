package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Page {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-information']")
    WebElement productInformationSection;

    @FindBy(id = "quantity")
    WebElement productQuantityTextBox;

    @FindBy(xpath = "//button[contains(.,'Add to cart')]")
    WebElement addToCartButton;

    public void productDetailPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(productInformationSection, "Product information section"), "Product detail page is visible");
    }

    public void userIncreasesProductQuantityToFour() {
        Log.info("User increases product quantity to four");
        ExtentReportManager.addTestStep("User increases product quantity to four");
        sendKeysToElement(productQuantityTextBox, "Product quantity text box", "4");
    }

    public void userClicksAddToCartButton() {
        Log.info("User clicks [Add to cart] button");
        ExtentReportManager.addTestStep("User clicks [Add to cart] button");
        clickElement(addToCartButton,  "[Add to cart] button");
    }
}
