package com.stefan.automation.stepdefinitions;

import com.stefan.automation.context.TestContext;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.managers.ScrollManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CommonSteps {

    private TestContext testContext;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("User data is generated")
    public void userDataIsGenerated() {
        testContext.setUser(FakeDataManager.generateUser());
    }

    @When("User scrolls to bottom of page")
    public void userScrollsToBottomOfPage() {
        Log.info("Scrolling to bottom of page");
        ExtentReportManager.addTestStep("User scrolls to bottom of page");
        ScrollManager.scrollToBottomOfPage();
    }
}
