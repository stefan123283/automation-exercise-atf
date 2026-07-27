package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.ProductDetailPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ProductDetailPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);

    @Then("Product detail page is visible")
    public void productDetailPageIsVisible(){
        productDetailPage.productDetailPageIsVisible();
    }
}
