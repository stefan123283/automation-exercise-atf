package com.stefan.automation.managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public final class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    public static String reportPath;

    private ExtentReportManager() {
    }

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {
            reportPath = "reports/ExtentReport.html";
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
            extentSparkReporter.config().setDocumentTitle("Automation Test Report");
            extentSparkReporter.config().setReportName("Test Execution Report");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
        }
        return extentReports;
    }

    public static ExtentTest createTest(String testName) {
        extentTest = getReportInstance().createTest(testName);
        return extentTest;
    }

    public static void addTestStep(String testStep) {
        extentTest.info(testStep);
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + ".png"));
            return "screenshots/" + screenshotName + ".png";
        } catch (IOException e) {
            Log.warn("Screenshoot was not saved!");
            return null;
        }
    }


}
