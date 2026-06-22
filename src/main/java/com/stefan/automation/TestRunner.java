package com.stefan.automation;

import com.stefan.automation.base.BaseTest;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.pageobjects.AccountCreatedPage;
import com.stefan.automation.pageobjects.AccountDeletedPage;
import com.stefan.automation.pageobjects.HomePage;
import com.stefan.automation.pageobjects.LoginPage;
import com.stefan.automation.managers.ExcelManager;
import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRunner extends BaseTest {

    @DataProvider(name = "RegistrationData")
    public Object[][] getRegisterData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/testdata/RegistrationTestData.xlsx";
        ExcelManager.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelManager.getRowCount();
        Object[][] data = new Object[rowCount - 1][2];
        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelManager.getCellData(i, 0);
            data[i - 1][1] = ExcelManager.getCellData(i, 1);
        }
        ExcelManager.closeExcel();
        return data;
    }

    @Test(dataProvider = "RegistrationData")
    public void testValidRegistration(String username, String email) {
        extentTest = ExtentReportManager.createTest("Test Case 1: Register User (" + email + ")");
        Log.info("Starting Test Case 1: Register User...");
        HomePage homePage = new HomePage(driver);
        extentTest.info("Verify that the Home page is visible successfully");
        Log.info("Verifying if the Home page is visible successfully...");
        homePage.verifyIfHomePageIsDisplayed();
        extentTest.info("Navigate to Login page");
        Log.info("Navigating to Login page...");
        homePage.navigateToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        extentTest.info("Verify that the \"New User Signup!\" heading is visible");
        Log.info("Verifying that the \"New User Signup!\" heading is visible...");
        loginPage.verifyIfNewUserSignupHeadingIsDisplayed();
        extentTest.info("Enter the username (" + username + ") for the new user");
        Log.info("Entering the username (" + username + ") for the new user");
        loginPage.enterNewUsername(username);
        extentTest.info("Enter the email (" + email + ") for the new user");
        Log.info("Entering the email (" + email + ") for the new user");
        loginPage.enterNewEmail(email);
        extentTest.info("Click the [Signup] button");
        Log.info("Clicking the [Signup] button");
        loginPage.clickTheSignupButton();
        extentTest.info("Verify that the \"Enter Account Information\" heading is visible");
        Log.info("Verifying that the \"Enter Account Information\" heading is visible...");
        loginPage.verifyIfEnterAccountInformationHeadingIsDisplayed();
        extentTest.info("Populate the registration form");
        Log.info("Populating the registration form...");
        loginPage.populateTheRegistrationForm(FakeDataManager.generateRandomPassword(), FakeDataManager.generateRandomDay(), FakeDataManager.generateRandomMonth(), FakeDataManager.generateRandomYear(),  FakeDataManager.generateRandomFirstName(),  FakeDataManager.generateRandomLastName(),  FakeDataManager.generateRandomCompany(),  FakeDataManager.generateRandomStreetAddress(),
                FakeDataManager.generateRandomState(), FakeDataManager.generateRandomCity(), FakeDataManager.generateRandomZipCode(), FakeDataManager.generateRandomMobileNumber());
        extentTest.info("Click the [Create Account] button");
        Log.info("Clicking the [Create Account] button...");
        loginPage.clickTheCreateAccountButton();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.info("Verify that the \"Account Created!\" heading is visible");
        Log.info("Verifying that the \"Account Created!\" heading is visible...");
        accountCreatedPage.verifyIfAccountCreatedHeadingIsDisplayed();
        extentTest.info("Click the [Continue] button");
        Log.info("Clicking the [Continue] button...");
        accountCreatedPage.clickTheContinueButton();
        extentTest.info("Verify that the \"Logged in as username\" link is visible");
        Log.info("Verifying that the \"Logged in as username\" link is visible...");
        homePage.verifyIfLoggedInAsUsernameLinkIsDisplayed();
        extentTest.info("Click the [Delete Account] button");
        Log.info("Clicking the [Delete Account] button...");
        homePage.clickTheDeleteAccountButton();

        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        extentTest.info("Verify that the \"Account Deleted!\" heading is visible");
        Log.info("Verifying that the \"Account Deleted!\" heading is visible...");
        accountDeletedPage.verifyIfAccountDeletedHeadingIsDisplayed();
        extentTest.info("Click the [Continue] button");
        Log.info("Clicking the [Continue] button...");
        accountDeletedPage.clickTheContinueButton();
        extentTest.pass("The test passed");
        Log.info("Test Case 1: Register User has passed!");
    }

}