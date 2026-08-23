package com.stefan.automation.stepdefinitions;

import com.stefan.automation.context.TestContext;
import com.stefan.automation.managers.*;
import com.stefan.automation.models.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiSteps {

    private ApiClient apiClient = new ApiClient();
    private final TestContext testContext;
    private User user;

    public ApiSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("User sends a {string} request to the {string} url")
    public void userSendsRequestToUrl(String requestMethod, String url) {
        ExtentReportManager.addTestStep("User sends a " + requestMethod + " request to the url: " + url);
        Log.info("User sends a " + requestMethod + " request to the url: " + url);
        apiClient.userSendsRequestToUrl(requestMethod, url);
    }

    @Then("Response code is {int}")
    public void responseCodeIs(int expectedResponseCode) {
        int actualResponseCode = apiClient.getResponseCode();
        AssertManager.assertTrue((actualResponseCode == expectedResponseCode), "The response code is: " + actualResponseCode);
    }

    @Then("Response message is {string}")
    public void responseMessageIs(String expectedResponseMessage) {
        String actualResponseMessage = apiClient.getResponseMessage();
        AssertManager.assertTrue((actualResponseMessage.equals(expectedResponseMessage)), "The response message is: " + actualResponseMessage);
    }

    @Given("User prepares the {string} request parameter with {string} value")
    public void userPreparesRequestParameter(String requestParameter, String value) {
        ExtentReportManager.addTestStep("User prepares the \"" + requestParameter + "\" request parameter with \"" + value + "\" value");
        Log.info("User prepares the \"" + requestParameter + "\" request parameter with \"" + value + "\" value");
        switch (value) {
            case "invalid email" -> value = FakeDataManager.generateRandomEmail();
            case "invalid password" -> value = FakeDataManager.generateRandomPassword();
            case "valid email" -> value = user.getEmail();
            case "valid password" -> value = user.getPassword();
        }
        apiClient.userPreparesRequestParameter(requestParameter, value);
    }

    @And("User prepares request parameters for registration")
    public void userPreparesRequestParametersForRegistration() {
        ExtentReportManager.addTestStep("User prepares request parameters for registration");
        Log.info("User prepares request parameters for registration");
        user = testContext.getUser();
        apiClient.userPreparesRequestParametersForRegistration(user.getUsername(), user.getEmail(), user.getPassword(), "Mr",
                user.getBirthDay(), user.getBirthMonth(), user.getBirthYear(), user.getFirstName(), user.getLastName(),
                user.getCompany(), user.getAddress(), user.getAddress(), "United States", user.getZipCode(),
                user.getState(), user.getCity(), user.getMobileNumber());
    }

}
