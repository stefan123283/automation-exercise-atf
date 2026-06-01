package com.stefan.automation.pages;

import com.stefan.automation.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LoginPage {

    private WebDriver driver;

    private By loginEmailTextBox = By.name("email");

    private By passwordTextBox = By.name("password");

    private By loginButton = By.xpath("//button[text()='Login']");

    private By nameTextBox = By.name("name");

    private By signUpEmailTextBox = RelativeLocator.with(loginEmailTextBox).toRightOf(passwordTextBox);

    private By signupButton = By.xpath("//button[text()='Signup']");

    //Enter Account Information

    private By mrCheckbox = By.xpath("//input[@value='Mr']");

    private By selectDaysBox = By.id("days");

    private By selectMonthsBox = By.id("months");

    private By yearsMonthsBox = By.id("years");

    private By newsletterCheckbox = By.id("newsletter");

    private By receiveSpecialOffersCheckbox = By.id("optin");

    //Address Information

    private By firstNameTextBox = By.id("first_name");

    private By lastNameTextBox = By.id("last_name");

    private By companyTextBox = By.id("company");

    private By address1TextBox = By.id("address1");

    private By address2TextBox = By.id("address2");

    private By stateTextBox = By.id("state");

    private By cityTextBox = By.id("city");

    private By zipCodeTextBox = By.id("zipcode");

    private By mobileNumberTextBox = By.id("mobile_number");

    private By createAccountButton = By.xpath("//button[text()='Create Account']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerNewUser(String name, String email) {
        Log.info("Entering the username and email for the new user");
        driver.findElement(nameTextBox).sendKeys(name);
        driver.findElement(signUpEmailTextBox).sendKeys(email);
        driver.findElement(signupButton).click();
    }

    public void enterAccountInformation(String password, String days, String monthFirstLetter, String year, String firstName, String lastName, String address1,
                                        String address2, String state, String city, String zipCode, String mobileNumber) {
        Log.info("Entering the account information");
        driver.findElement(mrCheckbox).click();
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(selectDaysBox).click();
        driver.findElement(selectDaysBox).sendKeys(days);
        driver.findElement(selectDaysBox).sendKeys("\\uE007");
        driver.findElement(selectMonthsBox).sendKeys(monthFirstLetter);
        driver.findElement(selectMonthsBox).sendKeys("\\uE007");
        driver.findElement(yearsMonthsBox).sendKeys(year);
        driver.findElement(yearsMonthsBox).sendKeys("\\uE007");
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(receiveSpecialOffersCheckbox).click();
        driver.findElement(firstNameTextBox).sendKeys(firstName);
        driver.findElement(lastNameTextBox).sendKeys(lastName);
        driver.findElement(address1TextBox).sendKeys(address1);
        driver.findElement(address2TextBox).sendKeys(address2);
        driver.findElement(stateTextBox).sendKeys(state);
        driver.findElement(cityTextBox).sendKeys(city);
        driver.findElement(zipCodeTextBox).sendKeys(zipCode);
        driver.findElement(mobileNumberTextBox).sendKeys(mobileNumber);
        driver.findElement(createAccountButton).click();
    }
}
