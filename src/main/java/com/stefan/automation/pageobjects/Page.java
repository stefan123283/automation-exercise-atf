package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    protected final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(), 'Products')]")
    WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cartLink;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginButton;

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

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsUserLink;

    protected boolean checkIfElementIsVisible(WebElement webElement, String elementName) {
        ExplicitWaitManager.waitUntilElementIsVisible(webElement, elementName);
        return webElement.isDisplayed();
    }

    protected void clickElement(WebElement webElement, String elementName) {
        checkIfElementIsVisible(webElement, elementName);
        webElement.click();
        Log.debug("\"" + elementName + "\" is clicked");
    }

    protected void sendKeysToElement(WebElement webElement, String elementName, String keys) {
        checkIfElementIsVisible(webElement, elementName);
        webElement.sendKeys(keys);
        Log.debug("Value is entered in the \"" + elementName + "\"");
    }

    protected void pressEnter(WebElement webElement, String elementName) {
        webElement.sendKeys("\\uE007");
        Log.debug("Pressed ENTER on \"" + elementName + "\"");
    }

    protected void switchToFrame(WebElement frame, String frameName) {
        checkIfElementIsVisible(frame, frameName);
        driver.switchTo().frame(frame);
        Log.debug("Switched to \"" + frameName + "\" context");
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        Log.debug("Switched back to the main page context");
    }

}
