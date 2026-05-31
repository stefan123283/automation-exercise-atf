package tests;

import com.stefan.automation.base.BaseTest;
import com.stefan.automation.pages.AccountCreatedPage;
import com.stefan.automation.pages.AccountDeletedPage;
import com.stefan.automation.pages.HomePage;
import com.stefan.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidRegistration() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
        //TODO Verify that home page is visible successfully
        homePage.navigateToLoginPage();
        //TODO Verify 'New User Signup!' is visible
        loginPage.registerNewUser("user1", "user1@randomemail.com");
        //TODO Verify that 'ENTER ACCOUNT INFORMATION' is visible
        loginPage.enterAccountInformation("Pa$sword!", "30", "J", "2000", "John", "Doe", "ansk3",
                "sjdn4", "sjd3", "snck2", "skd3", "123");
        //TODO Verify that 'ACCOUNT CREATED!' is visible
        accountCreatedPage.clickTheContinueButton();
        //TODO Verify that 'Logged in as username' is visible
        homePage.clickTheDeleteAccountButton();
        //TODO Verify that 'ACCOUNT DELETED!' is visible
        accountDeletedPage.clickTheContinueButton();
    }

}
