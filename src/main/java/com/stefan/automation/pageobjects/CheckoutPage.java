package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Page {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[text()='Checkout']")
    WebElement checkoutNavigationText;

    @FindBy(xpath = "//textarea[//label[text()='If you would like to add a comment about your order, please write it in the field below.']]")
    WebElement commentOrderTextBox;

    @FindBy(xpath = "//a[text()='Place Order']")
    WebElement placeOrderButton;

    @FindBy(id = "address_delivery")
    WebElement deliveryAddressSquare;

    @FindBy(id = "address_invoice")
    WebElement billingAddressSquare;

    public void checkoutPageIsVisible() {
        AssertManager.assertTrue(ExplicitWaitManager.checkIfElementIsVisible(checkoutNavigationText, "Checkout navigation text"), "Checkout page is visible");
    }

    public void userPlacesTheOrder() {
        Log.info("User places the order");
        ExtentReportManager.addTestStep("User places the order");
        KeyboardManager.enterValueIntoElement(commentOrderTextBox, "Comment order text box", "Order comment");
        clickElement(placeOrderButton, "[Place order] button");
    }

    public void theDeliveryAddressInformationIsCorrect(String firstName, String lastName, String company, String address, String state,
                                                       String city, String zipCode, String mobileNumber) {
        AssertManager.assertTrue(
                ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", firstName)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", lastName)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", company)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", address)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", state)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", city)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", zipCode)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(deliveryAddressSquare, "Delivering address square", mobileNumber)
                , "The delivery address information is correct");
    }

    public void theBillingAddressInformationIsCorrect(String firstName, String lastName, String company, String address, String state,
                                                      String city, String zipCode, String mobileNumber) {
        AssertManager.assertTrue(
                ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", firstName)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", lastName)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", company)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", address)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", state)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", city)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", zipCode)
                        && ExplicitWaitManager.checkIfElementContainsSpecificText(billingAddressSquare, "Billing address square", mobileNumber)
                , "The billing address information is correct");
    }

}
