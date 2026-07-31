package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CartPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("Cart page is visible")
    public void cartPageIsVisible() {
        cartPage.cartPageIsVisible();
    }

    @And("Both products are added to cart")
    public void bothProductsAreAddedToCart() {
        cartPage.bothProductsAreAddedToCart();
    }

    @And("Product is displayed with exact quantity")
    public void productIsDisplayedWithExactQuantity() {
        cartPage.productIsDisplayedWithExactQuantity();
    }

    @When("User clicks on [Proceed to Checkout] button")
    public void userClickOnProceedToCheckoutButton(){
        cartPage.userClickOnProceedToCheckoutButton();
    }

    @And("User clicks on [Register Login] button")
    public void userClickOnRegisterLoginButton(){
        cartPage.userClickOnRegisterLoginButton();
    }
}
