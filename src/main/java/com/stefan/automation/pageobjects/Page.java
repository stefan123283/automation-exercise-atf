package com.stefan.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(), 'Products')]")
    WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cartLink;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginLink;

    @FindBy(xpath = "//a[contains(text(), 'Contact us')]")
    WebElement contactUsLink;

    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement subscriptionHeading;

    @FindBy(id = "susbscribe_email")
    WebElement subscriptionEmailTextBox;

    @FindBy(id = "subscribe")
    WebElement submitSubscriptionEmailButton;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

}
