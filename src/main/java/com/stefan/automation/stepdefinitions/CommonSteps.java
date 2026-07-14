package com.stefan.automation.stepdefinitions;

import com.stefan.automation.context.TestContext;
import com.stefan.automation.managers.FakeDataManager;
import io.cucumber.java.en.And;

public class CommonSteps {

    private TestContext testContext;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @And("User data is generated")
    public void userDataIsGenerated() {
        testContext.setUser(FakeDataManager.generateUser());
    }
}
