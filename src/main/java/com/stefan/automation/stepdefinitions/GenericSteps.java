package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GenericSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The {string} url is accessed")
    public void accessUrl(String url) {
        Log.info("Accessing the \"" + url + " url\"...");
        ExtentReportManager.addTestStep("The \"" + url + " url\" is accessed");
        driver.get(url);
    }

}
