package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExtentReportManager;
import com.stefan.automation.managers.FakeDataManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='Mr']")
    WebElement mrCheckbox;

    @FindBy(id = "days")
    WebElement selectDaysBox;

    @FindBy(id = "months")
    WebElement selectMonthsBox;

    @FindBy(id = "years")
    WebElement selectYearsBox;

    @FindBy(id = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement receiveSpecialOffersCheckbox;

    @FindBy(id = "first_name")
    WebElement firstNameTextBox;

    @FindBy(id = "last_name")
    WebElement lastNameTextBox;

    @FindBy(id = "company")
    WebElement companyTextBox;

    @FindBy(id = "address1")
    WebElement addressTextBox;

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

    public void userCompletesRegistrationForm(String password, String birthDate, String birthMonth, String birthYear,
                                              String firstName, String lastName, String company, String address, String state,
                                              String city, String zipCode, String mobileNumber) {
        Log.info("Completing registration form");
        ExtentReportManager.addTestStep("User completes registration form");
        clickElement(mrCheckbox, "Mr. checkbox");
        sendKeysToElement(passwordTextBox, "Password text box", password);
        clickElement(selectDaysBox, "Select days box");
        sendKeysToElement(selectDaysBox, "Select days box", birthDate);
        pressEnter(selectDaysBox, "Select days box");
        sendKeysToElement(selectMonthsBox, "Select months box", birthMonth);
        pressEnter(selectMonthsBox, "Select months box");
        sendKeysToElement(selectYearsBox, "Select years box", birthYear);
        pressEnter(selectYearsBox, "Select years box");
        clickElement(newsletterCheckbox, "Newsletter checkbox");
        clickElement(receiveSpecialOffersCheckbox, "Receive special offers checkbox");
        sendKeysToElement(firstNameTextBox, "First name text box", firstName);
        sendKeysToElement(lastNameTextBox, "Last name text box", lastName);
        sendKeysToElement(companyTextBox, "Company text box", company);
        sendKeysToElement(addressTextBox, "Address text box", address);
        sendKeysToElement(stateTextBox, "State text box", state);
        sendKeysToElement(cityTextBox, "City text box", city);
        sendKeysToElement(zipCodeTextBox, "Zipcode text box", zipCode);
        sendKeysToElement(mobileNumberTextBox, "Mobile Number text box", mobileNumber);
        clickElement(createAccountButton, "[Create Account] button");
        Log.info("Registration form completed");
    }

}
