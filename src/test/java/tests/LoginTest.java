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
        Log.info("Starting Test Case 1: Register User...");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        homePage.verifyIfHomePageIsDisplayed();
        extentTest.info("Navigate to Login page");
        homePage.navigateToLoginPage();
        loginPage.verifyIfNewUserSignupHeadingIsDisplayed();
        extentTest.info("Enter the username and email for the new user");
        loginPage.registerNewUser("user1", "user1@randomemail.com");
        loginPage.verifyIfEnterAccountInformationHeadingIsDisplayed();
        extentTest.info("Enter the account information");
        loginPage.enterAccountInformation("Pa$sword!", "30", "J", "2000", "John", "Doe", "ansk3",
                "sjdn4", "sjd3", "snck2", "skd3", "123");
        accountCreatedPage.verifyIfAccountCreatedHeadingIsDisplayed();
        extentTest.info("Click the [Continue] button from the 'Account Created' page");
        accountCreatedPage.clickTheContinueButton();
        homePage.verifyIfLoggedInAsUsernameLinkIsDisplayed();
        extentTest.info("Click the [Delete Account] button from the 'Home' page");
        homePage.clickTheDeleteAccountButton();
        accountDeletedPage.verifyIfAccountDeletedHeadingIsDisplayed();
        extentTest.info("Click the [Continue] button from the 'Account Deleted' page");
        accountDeletedPage.clickTheContinueButton();
        extentTest.pass("Registration Successfully");
    }

}
