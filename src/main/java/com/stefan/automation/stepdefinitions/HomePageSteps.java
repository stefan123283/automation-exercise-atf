package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @When("User opens application")
    public void userOpensApplication() {
        homePage.userOpensApplication();
    }

    @Then("Home page is visible")
    public void homePageIsVisible() {
        homePage.homePageIsVisible();
    }

    @When("User navigates to Login page")
    public void loginPageIsAccessed() {
        homePage.userNavigatesToLoginPage();
    }

    @When("User deletes their account")
    public void userDeletesTheirAccount() {
        homePage.userDeletesTheirAccount();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        homePage.userIsLoggedInSuccessfully();
    }

    @When("User logs out")
    public void userLogsOut() {
        homePage.userLogsOut();
    }

    @When("User navigates to Contact us page")
    public void userNavigatesToContactUSPage() {
        homePage.userNavigatesToContactUSPage();
    }

    @When("User navigates to Test Cases page")
    public void userNavigatesToTestCasesPage() {
        homePage.userNavigatesToTestCasesPage();
    }

    @When("User navigates to All Products page")
    public void userNavigatesToAllProductsPage() {
        homePage.userNavigatesToAllProductsPage();
    }

    @Then("Subscription section is visible")
    public void subscriptionSectionIsVisible() {
        homePage.subscriptionSectionIsVisible();
    }

    @When("User submits subscription email address")
    public void userSubmitsSubscriptionEmailAddress() {
        homePage.userSubmitsSubscriptionEmailAddress(FakeDataManager.generateRandomEmail());
    }

    @Then("User is subscribed successfully")
    public void userIsSubscribedSuccessfully() {
        homePage.userIsSubscribedSuccessfully();
    }

    @When("User navigates to Cart page")
    public void userNavigatesToCartPage() {
        homePage.userNavigatesToCartPage();
    }

    @When("User navigates to Dress category page")
    public void userNavigatesToDressCategoryPage(){
        homePage.userNavigatesToDressCategoryPage();
    }

    @When("User navigates to Tshirts category page")
    public void userNavigatesToTshirtsCategoryPage(){
        homePage.userNavigatesToTshirtsCategoryPage();
    }

    @And("User adds to cart a recommended product")
    public void userAddsToCartRecommendedProduct(){
        homePage.userAddsToCartRecommendedProduct();
    }

    @And("User clicks the scroll up arrow")
    public void userClicksTheScrollUpArrow(){
        homePage.userClicksTheScrollUpArrow();
    }

    @Then("Page is scrolled up")
    public void pageIsScrolledUp(){
        homePage.pageIsScrolledUp();
    }
}
