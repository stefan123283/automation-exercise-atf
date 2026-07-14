package com.stefan.automation.stepdefinitions;

import com.stefan.automation.context.TestContext;
import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.pageobjects.RegistrationPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class RegistrationPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    private TestContext testContext;

    public RegistrationPageSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("User completes registration form")
    public void userCompletesRegistrationForm() {
        registrationPage.userCompletesRegistrationForm(testContext.getUser().getPassword(), testContext.getUser().getBirthDay(), testContext.getUser().getBirthMonth(),
                testContext.getUser().getBirthYear(), testContext.getUser().getFirstName(), testContext.getUser().getLastName(), testContext.getUser().getCompany()
                , testContext.getUser().getAddress(), testContext.getUser().getState(), testContext.getUser().getCity(), testContext.getUser().getZipCode(),
                testContext.getUser().getMobileNumber());
    }

}
