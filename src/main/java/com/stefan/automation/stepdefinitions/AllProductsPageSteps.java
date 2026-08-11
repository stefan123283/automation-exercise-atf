package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.pageobjects.AllProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AllProductsPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    AllProductsPage allProductsPage = new AllProductsPage(driver);

    @Then("All Products page is visible")
    public void allProductsPageIsVisible() {
        allProductsPage.allProductsPageIsVisible();
    }

    @When("User clicks on [View Product] button of first product")
    public void clickOnViewProductButtonOfFirstProduct() {
        allProductsPage.clickOnViewProductButtonOfFirstProduct();
    }

    @When("User search a specific product")
    public void userSearchASpecificProduct() {
        allProductsPage.userSearchASpecificProduct();
    }

    @Then("The searched product is visible")
    public void theSearchedProductIsVisible() {
        allProductsPage.theSearchedProductIsVisible();
    }

    @When("User adds first two products to cart")
    public void userAddsFirstTwoProductsToCart() {
        Log.info("User adds first two products to cart");
        ExtentReportManager.addTestStep("User adds first two products to cart");
        allProductsPage.userAddsFirstTwoProductsToCart();
    }

    @And("User clicks [View Cart] button")
    public void userClickViewCartButton() {
        Log.info("User clicks [View Cart] button");
        ExtentReportManager.addTestStep("User clicks [View Cart] button");
        allProductsPage.userClickViewCartButton();
    }

    @Then("Dress category page is visible")
    public void dressCategoryPageIsVisible() {
        allProductsPage.dressCategoryPageIsVisible();
    }

    @Then("Tshirts category page is visible")
    public void tShirtsCategoryPageIsVisible() {
        allProductsPage.tShirtsCategoryPageIsVisible();
    }

    @When("User navigates to Polo brand page")
    public void userNavigatesToPoloBrandPage() {
        allProductsPage.userNavigatesToPoloBrandPage();
    }

    @Then("Polo brand page is visible")
    public void poloBrandPageIsVisible() {
        allProductsPage.poloBrandPageIsVisible();
    }

    @When("User navigates to H&M brand page")
    public void userNavigatesToHAndMBrandPage() {
        allProductsPage.userNavigatesToHAndMBrandPage();
    }

    @Then("H&M brand page is visible")
    public void hAndMBrandPageIsVisible() {
        allProductsPage.hAndMBrandPageIsVisible();
    }
}
