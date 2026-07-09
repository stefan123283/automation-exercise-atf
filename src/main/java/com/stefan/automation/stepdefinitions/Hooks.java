package com.stefan.automation.stepdefinitions;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.time.Duration;
import java.time.Instant;

public class Hooks {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;
    private Instant startTime;
    private static final String FULL_SCREEN_MODE = ConfigReaderManager.getProperty("fullScreenMode");
    private static final int PAGE_LOAD_WAIT = Integer.parseInt(ConfigReaderManager.getProperty("pageLoadWait"));
    private static final String EMAIL_REPORT = ConfigReaderManager.getProperty("emailReport");

    @BeforeAll
    public static void beforeAllTest() {
        extentReports = ExtentReportManager.getReportInstance();
    }

    @Before
    public void beforeEachTest(Scenario scenario) {
        startTime = Instant.now();
        extentTest = ExtentReportManager.createTest("Test case: " + scenario.getName());
        Log.info("Starting test case: " + scenario.getName());
        driver = DriverManager.getInstance().getDriver();
        if (FULL_SCREEN_MODE.equals("enabled")) {
            Log.info("Starting the browser in full screen mode");
            driver.manage().window().maximize();
        }
        Log.info("Waiting page to load completely (timeout: " + PAGE_LOAD_WAIT + " seconds)");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
    }

    @After
    public void afterEachTest(Scenario scenario) {

        Duration duration = Duration.between(startTime, Instant.now());

        if (scenario.isFailed()) {
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, scenario.getName());
            extentTest.fail("The test failed. Check the attached screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            Log.error("Screenshot saved to: " + screenshotPath);
            Log.info("Test case failed: " + scenario.getName() + " (Duration: " + duration.toSeconds() + "s)");
        } else {
            Log.info("Test case completed successfully: " + scenario.getName() + " (Duration: " + duration.toSeconds() + "s)");
        }

        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAllTest() {
        extentReports.flush();
        if (EMAIL_REPORT.equals("enabled")) {
            EmailManager.sendTestReport(ExtentReportManager.reportPath);
        }
    }

}
