package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.TestCasesPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class TestCasesPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    TestCasesPage testCasesPage = new TestCasesPage(driver);

    @Then("Test Cases page is visible")
    public void testCasesPageIsVisible(){
        testCasesPage.testCasesPageIsVisible();
    }
}
