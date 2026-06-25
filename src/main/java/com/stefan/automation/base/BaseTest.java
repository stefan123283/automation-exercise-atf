package com.stefan.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.EmailManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;
    private static int testCount;

    @BeforeAll
    public static void beforeAll() {
        extentReports = ExtentReportManager.getReportInstance();
    }

    @AfterAll
    public static void afterAll() {
        extentReports.flush();
        String reportPath = ExtentReportManager.reportPath;
        Log.info("The path of the report is: " + reportPath);

        if (driver != null) {
            Log.info("Closing the WebDriver instance...");
            driver.quit();
        }

    @BeforeEach
    public void beforeEach() {
        testCount++;
        driver = DriverManager.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("Navigating to url \"https://automationexercise.com\"...");
        driver.get("https://automationexercise.com");
    }

    @RegisterExtension
    TestWatcher watcher = new TestWatcher() {

        @Override
        public void testFailed(ExtensionContext context, Throwable e) {
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, context.getRequiredTestMethod().getName() + "_" + testCount);
            extentTest.fail("The test failed. Check the attached screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            DriverManager.getInstance().quitTheDriver();
        }

        @Override
        public void testSuccessful(ExtensionContext context) {
            DriverManager.getInstance().quitTheDriver();
        }

        @Override
        public void testAborted(ExtensionContext context, Throwable cause) {
            DriverManager.getInstance().quitTheDriver();
        }
    };

}
