package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.EmailManager;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;

import java.time.Duration;

public class Hooks {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;
    private static int testCount;

    @BeforeAll
    public static void beforeAllTest() {
        extentReports = ExtentReportManager.getReportInstance();
    }

    @Before
    public void beforeEachTest(Scenario scenario) {
        testCount++;
        extentTest = ExtentReportManager.createTest("Test Case: " + scenario.getName() + "_" + testCount);
        Log.info("Starting Test Case: " + scenario.getName() + "...");
        driver = DriverManager.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void afterEachTest(Scenario scenario) {

        if (scenario.isFailed()) {
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, "Failed_test_case_" + testCount);
            extentTest.fail("The test failed. Check the attached screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAllTest() {
        extentReports.flush();
//        EmailManager.sendTestReport(ExtentReportManager.reportPath);
    }

}
