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

    public void userCompletesRegistrationForm() {
        Log.info("Completing registration form");
        ExtentReportManager.addTestStep("User completes registration form");
        clickElement(mrCheckbox, "Mr. checkbox");
        sendKeysToElement(passwordTextBox, "Password text box", FakeDataManager.generateRandomPassword());
        clickElement(selectDaysBox, "Select days box");
        sendKeysToElement(selectDaysBox, "Select days box", FakeDataManager.generateRandomDay());
        pressEnter(selectDaysBox, "Select days box");
        sendKeysToElement(selectMonthsBox, "Select months box", FakeDataManager.generateRandomMonth());
        pressEnter(selectMonthsBox, "Select months box");
        sendKeysToElement(selectYearsBox, "Select years box", FakeDataManager.generateRandomYear());
        pressEnter(selectYearsBox, "Select years box");
        clickElement(newsletterCheckbox, "Newsletter checkbox");
        clickElement(receiveSpecialOffersCheckbox, "Receive special offers checkbox");
        sendKeysToElement(firstNameTextBox, "First name text box", FakeDataManager.generateRandomFirstName());
        sendKeysToElement(lastNameTextBox, "Last name text box", FakeDataManager.generateRandomLastName());
        sendKeysToElement(companyTextBox, "Company text box", FakeDataManager.generateRandomCompany());
        sendKeysToElement(addressTextBox, "Address text box", FakeDataManager.generateRandomStreetAddress());
        sendKeysToElement(stateTextBox, "State text box", FakeDataManager.generateRandomState());
        sendKeysToElement(cityTextBox, "City text box", FakeDataManager.generateRandomCity());
        sendKeysToElement(zipCodeTextBox, "Zipcode text box", FakeDataManager.generateRandomZipCode());
        sendKeysToElement(mobileNumberTextBox, "Mobile Number text box", FakeDataManager.generateRandomMobileNumber());
        clickElement(createAccountButton, "[Create Account] button");
        Log.info("Registration form completed");
    }


}
