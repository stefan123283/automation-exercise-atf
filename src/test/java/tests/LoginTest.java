package tests;

import com.stefan.automation.base.BaseTest;
import com.stefan.automation.pages.AccountCreatedPage;
import com.stefan.automation.pages.AccountDeletedPage;
import com.stefan.automation.pages.HomePage;
import com.stefan.automation.pages.LoginPage;
import com.stefan.automation.utils.ExtentReportManager;
import com.stefan.automation.utils.Log;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidRegistration() {
        extentTest = ExtentReportManager.createTest("Test Case 1: Register User");
        Log.info("Starting Test Case 1: Register User");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        //TODO Verify that home page is visible successfully
        extentTest.info("Navigate to Login page");
        homePage.navigateToLoginPage();
        //TODO Verify 'New User Signup!' is visible
        extentTest.info("Enter the username and email for the new user");
        loginPage.registerNewUser("user1", "user1@randomemail.com");
        //TODO Verify that 'ENTER ACCOUNT INFORMATION' is visible
        extentTest.info("Enter the account information");
        loginPage.enterAccountInformation("Pa$sword!", "30", "J", "2000", "John", "Doe", "ansk3",
                "sjdn4", "sjd3", "snck2", "skd3", "123");
        //TODO Verify that 'ACCOUNT CREATED!' is visible
        extentTest.info("Click the [Continue] button from the 'Account Created' page");
        accountCreatedPage.clickTheContinueButton();
        //TODO Verify that 'Logged in as username' is visible
        extentTest.info("Click the [Delete Account] button from the 'Home' page");
        homePage.clickTheDeleteAccountButton();
        //TODO Verify that 'ACCOUNT DELETED!' is visible
        extentTest.info("Click the [Continue] button from the 'Account Deleted' page");
        accountDeletedPage.clickTheContinueButton();
        extentTest.pass("Registration Successfully");
    }

}
