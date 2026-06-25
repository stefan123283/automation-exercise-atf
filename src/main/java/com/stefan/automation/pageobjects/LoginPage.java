package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    WebElement newUserSignupHeading;

    @FindBy(name = "email")
    WebElement loginEmailTextBox;

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(name = "name")
    WebElement usernameTextBox;

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

    public void verifyIfNewUserSignupHeadingIsDisplayed() {
        Assertions.assertTrue(newUserSignupHeading.isDisplayed(), "The \"New User Signup!\" heading is displayed");
    }

    public void verifyIfEnterAccountInformationHeadingIsDisplayed() {
        Assertions.assertTrue(enterAccountInformationHeading.isDisplayed(), "The \"Enter Account Information\" heading is displayed");
    }

    public void enterNewUsername(String username){
        usernameTextBox.sendKeys(username);
    }

    public void enterNewEmail(String email){
        signUpEmailTextBox.sendKeys(email);
    }

    public void clickTheSignupButton(){
        signupButton.click();
    }

    public void populateTheRegistrationForm(String password, String days, String monthFirstLetter, String year, String firstName, String lastName, String company, String address1,
                                            String state, String city, String zipCode, String mobileNumber) {
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
        companyTextBox.sendKeys(company);
        address1TextBox.sendKeys(address1);
        stateTextBox.sendKeys(state);
        cityTextBox.sendKeys(city);
        zipCodeTextBox.sendKeys(zipCode);
        mobileNumberTextBox.sendKeys(mobileNumber);
    }

    public void clickTheCreateAccountButton(){
        createAccountButton.click();
    }
}
