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
        String actualDeliveryAddress = getElementAttributeValue(deliveryAddressSquare, "Delivering address square", "innerText");
        AssertManager.assertTrue(actualDeliveryAddress.contains(firstName)
                        && (actualDeliveryAddress.contains(lastName))
                        && (actualDeliveryAddress.contains(company))
                        && (actualDeliveryAddress.contains(address))
                        && (actualDeliveryAddress.contains(state))
                        && (actualDeliveryAddress.contains(city))
                        && (actualDeliveryAddress.contains(zipCode))
                        && (actualDeliveryAddress.contains(mobileNumber))
                , "The delivery address information is correct");
    }

    public void theBillingAddressInformationIsCorrect(String firstName, String lastName, String company, String address, String state,
                                                      String city, String zipCode, String mobileNumber) {
        String actualBillingAddress = getElementAttributeValue(billingAddressSquare, "Billing address square", "innerText");
        ;
        AssertManager.assertTrue(actualBillingAddress.contains(firstName)
                        && (actualBillingAddress.contains(lastName))
                        && (actualBillingAddress.contains(company))
                        && (actualBillingAddress.contains(address))
                        && (actualBillingAddress.contains(state))
                        && (actualBillingAddress.contains(city))
                        && (actualBillingAddress.contains(zipCode))
                        && (actualBillingAddress.contains(mobileNumber))
                , "The billing address information is correct");
    }

}
