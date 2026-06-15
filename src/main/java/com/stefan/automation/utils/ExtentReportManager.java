package com.stefan.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    public static String reportPath;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            reportPath = "reports/ExtentReport_" + timestamp + ".html";
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

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String reportDir = System.getProperty("user.dir") + "/reports";
            String screenshotDir = reportDir + "/screenshots";

            File directory = new File(screenshotDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String absolutePath = screenshotDir + "/" + screenshotName + ".png";
            FileUtils.copyFile(src, new File(absolutePath));

            return "screenshots/" + screenshotName + ".png";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
