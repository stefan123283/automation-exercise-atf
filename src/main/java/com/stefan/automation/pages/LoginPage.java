package com.stefan.automation.pages;

import com.stefan.automation.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupHeading;

    @FindBy(name = "email")
    WebElement loginEmailTextBox;

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(name = "name")
    WebElement nameTextBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailTextBox;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupButton;

    //Enter Account Information

    @FindBy(xpath = "//h2[.='Enter Account Information']")
    WebElement enterAccountInformationHeading;

    @FindBy(xpath = "//input[@value='Mr']")
    WebElement mrCheckbox;

    @FindBy(id = "days")
    WebElement selectDaysBox;

    @FindBy(id = "months")
    WebElement selectMonthsBox;

    @FindBy(id = "years")
    WebElement yearsMonthsBox;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement receiveSpecialOffersCheckbox;

    //Address Information

    @FindBy(id = "first_name")
    WebElement firstNameTextBox;

    @FindBy(id = "last_name")
    WebElement lastNameTextBox;

    @FindBy(id = "company")
    WebElement companyTextBox;

    @FindBy(id = "address1")
    WebElement address1TextBox;

    @FindBy(id = "address2")
    WebElement address2TextBox;

    @FindBy(id = "state")
    WebElement stateTextBox;

    @FindBy(id = "city")
    WebElement cityTextBox;

    @FindBy(id = "zipcode")
    WebElement zipCodeTextBox;

    @FindBy(id = "mobile_number")
    WebElement mobileNumberTextBox;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createAccountButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyIfNewUserSignupHeadingIsDisplayed(){
        Assert.assertTrue(newUserSignupHeading.isDisplayed(), "The 'New User Signup!' heading is not displayed");
    }

    public void verifyIfEnterAccountInformationHeadingIsDisplayed(){
        Assert.assertTrue(enterAccountInformationHeading.isDisplayed(), "The 'ENTER ACCOUNT INFORMATION' heading is not displayed");
    }

    public void registerNewUser(String username, String email) {
        Log.info("Entering the username and email for the new user...");
        nameTextBox.sendKeys(username);
        signUpEmailTextBox.sendKeys(email);
        signupButton.click();
    }

    public void enterAccountInformation(String password, String days, String monthFirstLetter, String year, String firstName, String lastName, String address1,
                                        String address2, String state, String city, String zipCode, String mobileNumber) {
        Log.info("Entering the account information...");
        mrCheckbox.click();
        passwordTextBox.sendKeys(password);
        selectDaysBox.click();
        selectDaysBox.sendKeys(days);
        selectDaysBox.sendKeys("\\uE007");
        selectMonthsBox.sendKeys(monthFirstLetter);
        selectMonthsBox.sendKeys("\\uE007");
        yearsMonthsBox.sendKeys(year);
        yearsMonthsBox.sendKeys("\\uE007");
        newsletterCheckbox.click();
        receiveSpecialOffersCheckbox.click();
        firstNameTextBox.sendKeys(firstName);
        lastNameTextBox.sendKeys(lastName);
        address1TextBox.sendKeys(address1);
        address2TextBox.sendKeys(address2);
        stateTextBox.sendKeys(state);
        cityTextBox.sendKeys(city);
        zipCodeTextBox.sendKeys(zipCode);
        mobileNumberTextBox.sendKeys(mobileNumber);
        createAccountButton.click();
    }
}
