package tests;

import com.stefan.automation.base.BaseTest;
import com.stefan.automation.pages.AccountCreatedPage;
import com.stefan.automation.pages.AccountDeletedPage;
import com.stefan.automation.pages.HomePage;
import com.stefan.automation.pages.LoginPage;
import com.stefan.automation.utils.ExcelUtils;
import com.stefan.automation.utils.ExtentReportManager;
import com.stefan.automation.utils.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @DataProvider(name = "RegistrationData")
    public Object[][] getRegisterData() throws IOException {
        String filePath = System.getProperty("user.dir") + "/testdata/RegistrationTestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][2];
        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = ExcelUtils.getCellData(i, 0);
            data[i - 1][1] = ExcelUtils.getCellData(i, 1);
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "RegistrationData")
    public void testValidRegistration(String username, String email) {
        extentTest = ExtentReportManager.createTest("Test Case 1: Register User (" + email + ")");
        Log.info("Starting Test Case 1: Register User...");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        homePage.verifyIfHomePageIsDisplayed();
        extentTest.info("Navigate to Login page");
        Log.info("Navigating to Login page...");
        homePage.navigateToLoginPage();
        loginPage.verifyIfNewUserSignupHeadingIsDisplayed();
        extentTest.info("Enter the username and email for the new user");
        Log.info("Entering the username (" + username + ") and email (" + email + ") for the new user");
        loginPage.registerNewUser(username, email);
        loginPage.verifyIfEnterAccountInformationHeadingIsDisplayed();
        extentTest.info("Enter the account information");
        Log.info("Entering the account information...");
        loginPage.enterAccountInformation("Pa$sword!", "30", "J", "2000", "John", "Doe", "ansk3",
                "sjdn4", "sjd3", "snck2", "skd3", "123");
        accountCreatedPage.verifyIfAccountCreatedHeadingIsDisplayed();
        extentTest.info("Click the [Continue] button from the 'Account Created' page");
        Log.info("Clicking the [Continue] button from the 'Account Created' page...");
        accountCreatedPage.clickTheContinueButton();
        homePage.verifyIfLoggedInAsUsernameLinkIsDisplayed();
        extentTest.info("Click the [Delete Account] button from the 'Home' page");
        Log.info("Clicking the [Delete Account] button from the 'Home' page...");
        homePage.clickTheDeleteAccountButton();
        accountDeletedPage.verifyIfAccountDeletedHeadingIsDisplayed();
        extentTest.info("Click the [Continue] button from the 'Account Deleted' page");
        Log.info("Clicking the [Continue] button from the 'Account Deleted' page...");
        accountDeletedPage.clickTheContinueButton();
        extentTest.pass("Registration Successfully");
        Log.info("Test Case 1: Register User has passed!");
    }

}
