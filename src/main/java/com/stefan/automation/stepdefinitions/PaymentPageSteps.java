package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.pageobjects.PaymentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PaymentPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    PaymentPage paymentPage = new PaymentPage(driver);

    @Then("Payment page is visible")
    public void paymentPageIsVisible() {
        paymentPage.paymentPageIsVisible();
    }

    @When("User populates the payment form")
    public void userPopulatesThePaymentForm() {
        paymentPage.userPopulatesThePaymentForm(
                FakeDataManager.generateRandomFirstName() + " " + FakeDataManager.generateRandomLastName(),
                FakeDataManager.generateRandomCardNumber(),
                "123",
                "01",
                FakeDataManager.generateRandomYear());
    }
}
