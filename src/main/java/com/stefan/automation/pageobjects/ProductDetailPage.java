package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.AssertManager;
import com.stefan.automation.managers.ExplicitWaitManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Page {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-information']")
    WebElement productInformationSection;

    public void productDetailPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(productInformationSection, "Product information section"), "Product detail page is visible");
    }
}
