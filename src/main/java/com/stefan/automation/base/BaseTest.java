package com.stefan.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.stefan.automation.managers.DriverManager;
import com.stefan.automation.managers.EmailManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = DriverManager.getInstance().getDriver();
    protected static ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeSuite
    public void beforeSuite() {
        extentReports = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
        String reportPath = ExtentReportManager.reportPath;
        Log.info("The path of the report is: " + reportPath);

        if (driver != null) {
            Log.info("Closing the WebDriver instance...");
            driver.quit();
        }

        EmailManager.sendTestReport(reportPath);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("Navigating to the Automation Exercise website...");
        driver.get("https://automationexercise.com");
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ExtentReportManager.captureScreenshot(driver, iTestResult.getName());
            extentTest.fail("The test has failed. Check the attached screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }

    }

}
