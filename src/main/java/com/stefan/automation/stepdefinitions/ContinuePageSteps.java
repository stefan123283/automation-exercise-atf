package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.ContinuePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ContinuePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    ContinuePage continuePage = new ContinuePage(driver);

    @And("Account Created! is visible")
    public void verifyAccountCreatedIsVisible() {
        continuePage.verifyAccountCreatedIsVisible();
    }

    @And("[Continue] button is clicked")
    public void clickTheContinueButton() {
        continuePage.clickTheContinueButton();
    }

    @Then("Account Deleted! is visible")
    public void verifyAccountDeletedIsVisible() {
        continuePage.verifyAccountDeletedIsVisible();
    }

}
