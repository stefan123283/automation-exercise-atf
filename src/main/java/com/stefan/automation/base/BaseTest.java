package com.stefan.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.stefan.automation.utils.ExtentReportManager;
import com.stefan.automation.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeSuite
    public void setupReport() {
        extentReports = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void tearDownReport() {
        extentReports.flush();
    }

    @BeforeMethod
    public void setUp() {
        Log.info("Starting the WebDriver instance");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("Navigating to the Automation Exercise website");
        driver.get("https://automationexercise.com");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, iTestResult.getName());
            extentTest.fail("The test has failed. Check the attached screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

        if (driver != null) {
            Log.info("Closing the WebDriver instance");
            driver.quit();
        }
    }

}
