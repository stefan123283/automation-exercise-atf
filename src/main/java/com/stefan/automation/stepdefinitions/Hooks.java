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
        String scenarioName = scenario.getName();
        extentTest = ExtentReportManager.createTest("Test case: " + scenarioName);
        Log.info("Starting test case: " + scenarioName);
        if (!ApiClient.isApiTest(scenario)) {
            driver = DriverManager.getInstance().getDriver();
            if (FULL_SCREEN_MODE.equals("enabled")) {
                Log.info("Starting the browser in full screen mode");
                driver.manage().window().maximize();
            }
            Log.info("Waiting page to load completely (timeout: " + PAGE_LOAD_WAIT + " seconds)");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
        }
    }

    @After
    public void afterEachTest(Scenario scenario) {
        Duration duration = Duration.between(startTime, Instant.now());
        String scenarioName = scenario.getName();

        if (scenario.isFailed()) {
            if (!(ApiClient.isApiTest(scenario))) {
                String screenshotPath = ExtentReportManager.captureScreenshot(driver, scenarioName);
                extentTest.fail("The test has failed. Check the attached screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                Log.error("Screenshot saved to: " + screenshotPath);
            } else {
                extentTest.fail("The test has failed");
            }
            Log.info("Test case failed: " + scenarioName + " (Duration: " + duration.toSeconds() + "s)");
        } else {
            Log.info("Test case completed successfully: " + scenarioName + " (Duration: " + duration.toSeconds() + "s)");
        }

        if (!(ApiClient.isApiTest(scenario))) {
            DriverManager.getInstance().quitTheDriver();
        }
    }

    @AfterAll
    public static void afterAllTest() {
        extentReports.flush();
        if (EMAIL_REPORT.equals("enabled")) {
            EmailManager.sendTestReport(ExtentReportManager.reportPath);
        }
    }

}
