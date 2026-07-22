package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.pageobjects.ContactUsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ContactUsPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @And("User completes Contact us form")
    public void userCompletesContactUsForm() {
        contactUsPage.userCompletesContactUsForm(FakeDataManager.generateRandomFirstName(), FakeDataManager.generateRandomEmail(), "Subject", "Message");
    }

    @Then("Contact us form is submitted successfully")
    public void contactUsFormIsSubmittedSuccessfully() {
        contactUsPage.contactUsFormIsSubmittedSuccessfully();
    }

    @When("User navigates to Home page")
    public void userNavigatesToHomePage() {
        contactUsPage.userNavigatesToHomePage();
    }
}
