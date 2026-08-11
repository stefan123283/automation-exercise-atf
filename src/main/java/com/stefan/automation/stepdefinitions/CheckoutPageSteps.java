package com.stefan.automation.stepdefinitions;

import com.stefan.automation.context.TestContext;
import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CheckoutPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    private TestContext testContext;

    public CheckoutPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Checkout page is visible")
    public void checkoutPageIsVisible() {
        checkoutPage.checkoutPageIsVisible();
    }

    @When("User places the order")
    public void userPlacesTheOrder() {
        checkoutPage.userPlacesTheOrder();
    }

    @Then("The delivery address information is correct")
    public void theDeliveryAddressInformationIsCorrect() {
        checkoutPage.theDeliveryAddressInformationIsCorrect(testContext.getUser().getFirstName(), testContext.getUser().getLastName(), testContext.getUser().getCompany()
                , testContext.getUser().getAddress(), testContext.getUser().getState(), testContext.getUser().getCity(), testContext.getUser().getZipCode()
                , testContext.getUser().getMobileNumber());
    }

    @And("The billing address information is correct")
    public void theBillingAddressInformationIsCorrect() {
        checkoutPage.theBillingAddressInformationIsCorrect(testContext.getUser().getFirstName(), testContext.getUser().getLastName(), testContext.getUser().getCompany()
                , testContext.getUser().getAddress(), testContext.getUser().getState(), testContext.getUser().getCity(), testContext.getUser().getZipCode()
                , testContext.getUser().getMobileNumber());
    }
}
