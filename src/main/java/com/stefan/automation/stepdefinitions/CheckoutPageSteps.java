package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CheckoutPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Then("Checkout page is visible")
    public void checkoutPageIsVisible(){
        checkoutPage.checkoutPageIsVisible();
    }

    @When("User places the order")
    public void userPlacesTheOrder(){
        checkoutPage.userPlacesTheOrder();
    }
}
