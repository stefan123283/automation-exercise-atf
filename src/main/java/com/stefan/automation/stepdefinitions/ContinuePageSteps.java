package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.ContinuePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContinuePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    ContinuePage continuePage = new ContinuePage(driver);

    @Then("Account is created successfully")
    public void accountIsCreatedSuccessfully() {
        continuePage.accountIsCreatedSuccessfully();
    }

    @Then("Account is deleted successfully")
    public void accountIsDeletedSuccessfully() {
        continuePage.accountIsDeletedSuccessfully();
    }

    @Then("Order is placed successfully")
    public void orderPlacedSuccessfully() {
        continuePage.orderPlacedSuccessfully();
    }

    @When("User downloads the invoice")
    public void userDownloadsTheInvoice(){
        continuePage.userDownloadsTheInvoice();
    }

    @Then("Invoice is downloaded successfully")
    public void theInvoiceIsDownloadedSuccessfully(){
        continuePage.invoiceIsDownloadedSuccessfully("invoice.txt");
    }

}
