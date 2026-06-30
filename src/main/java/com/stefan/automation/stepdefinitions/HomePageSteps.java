package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @And("Home page is visible successfully")
    public void verifyHomePageIsVisible() {
        homePage.verifyHomePageIsVisible();
    }

    @And("[Login] button is clicked")
    public void clickOnLoginButton() {
        homePage.clickOnLoginButton();
    }

    @And("Logged in as username is visible")
    public void verifyLoggedInAsUsernameLinkIsVisible() {
        homePage.verifyLoggedInAsUsernameLinkIsVisible();
    }

    @When("[Delete Account] button is clicked")
    public void clickTheDeleteAccountButton() {
        homePage.clickTheDeleteAccountButton();
    }

}
