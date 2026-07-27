package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.CartPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CartPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("Cart page is visible")
    public void cartPageIsVisible() {
        cartPage.cartPageIsVisible();
    }
}
