package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.AllProductsPage;
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
}
