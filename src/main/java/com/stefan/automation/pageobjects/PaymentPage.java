package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Page {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[text()='Payment']")
    WebElement paymentNavigationText;

    @FindBy(xpath = "//label[text()='Name on Card']//../input")
    WebElement nameOnCardTextBox;

    @FindBy(xpath = "//label[text()='Card Number']//../input")
    WebElement cardNumberTextBox;

    @FindBy(xpath = "//label[text()='CVC']//../input")
    WebElement cvcTextBox;

    @FindBy(xpath = "//input[@placeholder='MM']")
    WebElement expirationMonthTextBox;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    WebElement expirationYearTextBox;

    @FindBy(xpath = "//button[text()='Pay and Confirm Order']")
    WebElement payAndConfirmOrderButton;

    public void paymentPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(paymentNavigationText, "Payment navigation text"), "Payment page is visible");
    }

    public void userPopulatesThePaymentForm(String nameOnCard, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
        Log.info("User populates the payment form");
        ExtentReportManager.addTestStep("User populates the payment form");
        KeyboardManager.enterValueIntoElement(nameOnCardTextBox, "Name on card text box", nameOnCard);
        KeyboardManager.enterValueIntoElement(cardNumberTextBox, "Card number text box", cardNumber);
        KeyboardManager.enterValueIntoElement(cvcTextBox, "CVC text box", cvc);
        KeyboardManager.enterValueIntoElement(expirationMonthTextBox, "Expiration month text box", expirationMonth);
        KeyboardManager.enterValueIntoElement(expirationYearTextBox, "Expiration year text box", expirationYear);
        clickElement(payAndConfirmOrderButton, "[Pay and Confirm Order] button");
    }

}
