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
    WebElement yearsMonthsBox;

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
        Log.info("Completing registration form...");
        ExtentReportManager.addTestStep("User completes registration form");
        Log.info("Checking the \"Mr.\" checkbox...");
        mrCheckbox.click();
        String password = FakeDataManager.generateRandomPassword();
        Log.info("Entering the \"" + password + "\" value in the \"Password\" field");
        passwordTextBox.sendKeys(password);
        String days = FakeDataManager.generateRandomDay();
        Log.info("Selecting the \"" + days + "\" value as the value of the \"Day\" field");
        selectDaysBox.click();
        selectDaysBox.sendKeys(days);
        selectDaysBox.sendKeys("\\uE007");
        String monthFirstLetter = FakeDataManager.generateRandomMonth();
        Log.info("Entering the \"" + monthFirstLetter + "\" value in the \"Month\" field");
        selectMonthsBox.sendKeys(monthFirstLetter);
        selectMonthsBox.sendKeys("\\uE007");
        String year = FakeDataManager.generateRandomYear();
        Log.info("Entering the \"" + year + "\" value in the \"Year\" field");
        yearsMonthsBox.sendKeys(year);
        yearsMonthsBox.sendKeys("\\uE007");
        Log.info("Checking the \"Sign up for our newsletter!\" checkbox...");
        newsletterCheckbox.click();
        Log.info("Checking the \"Receive special offers from our partners!\" checkbox...");
        receiveSpecialOffersCheckbox.click();
        String firstName = FakeDataManager.generateRandomFirstName();
        Log.info("Entering the \"" + firstName + "\" value in the \"First name\" field");
        firstNameTextBox.sendKeys(firstName);
        String lastName = FakeDataManager.generateRandomLastName();
        Log.info("Entering the \"" + lastName + "\" value in the \"Last name\" field");
        lastNameTextBox.sendKeys(lastName);
        String company = FakeDataManager.generateRandomCompany();
        Log.info("Entering the \"" + company + "\" value in the \"Company\" field");
        companyTextBox.sendKeys(company);
        String address = FakeDataManager.generateRandomStreetAddress();
        Log.info("Entering the \"" + address + "\" value in the \"Address\" field");
        addressTextBox.sendKeys(address);
        String state = FakeDataManager.generateRandomState();
        Log.info("Entering the \"" + state + "\" value in the \"State\" field");
        stateTextBox.sendKeys(state);
        String city = FakeDataManager.generateRandomCity();
        Log.info("Entering the \"" + city + "\" value in the \"City\" field");
        cityTextBox.sendKeys(city);
        String zipCode = FakeDataManager.generateRandomZipCode();
        Log.info("Entering the \"" + zipCode + "\" value in the \"Zipcode\" field");
        zipCodeTextBox.sendKeys(zipCode);
        String mobileNumber = FakeDataManager.generateRandomMobileNumber();
        Log.info("Entering the \"" + mobileNumber + "\" value in the \"Mobile Number\" field");
        mobileNumberTextBox.sendKeys(mobileNumber);
        Log.info("Clicking [Create Account] button...");
        createAccountButton.click();
    }


}
