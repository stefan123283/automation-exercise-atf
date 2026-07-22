package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//div[text()='Close']")
    WebElement closeAddButton;

    @FindBy(xpath = "//a[contains(text(), 'Test Cases')]")
    WebElement testCasesButton;

    protected void clickElement(WebElement webElement, String elementName) {
        ExplicitWaitManager.waitUntilElementIsClickable(webElement, elementName);
        try {
            webElement.click();
        } catch (ElementClickInterceptedException e) {
            Log.debug("Click intercepted for " + elementName + ". Trying JavaScript click");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        }
        Log.debug("\"" + elementName + "\" is clicked");
    }

    protected void sendKeysToElement(WebElement webElement, String elementName, String keys) {
        ExplicitWaitManager.waitUntilElementIsVisible(webElement, elementName);
        webElement.sendKeys(keys);
        Log.debug("Value is entered in the \"" + elementName + "\"");
    }

    protected void pressEnter(WebElement webElement, String elementName) {
        webElement.sendKeys("\\uE007");
        Log.debug("Pressed ENTER on \"" + elementName + "\"");
    }

    protected void switchToFrame(WebElement frame, String frameName) {
        driver.switchTo().frame(frame);
        Log.debug("Switched to \"" + frameName + "\" context");
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        Log.debug("Switched back to the main page context");
    }

    protected void acceptAlert() {
        ExplicitWaitManager.waitUntilAlertIsVisible();
        Log.debug("Accepting the Javascript alert");
        driver.switchTo().alert().accept();
    }

    public void closePopUpAddIfPresent() {
        List<WebElement> adsFrameList = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
        Log.debug("The size of the ads frame list: " + adsFrameList.size());
        if (!adsFrameList.isEmpty() && adsFrameList.getLast().isDisplayed()) {
            switchToFrame(adsFrameList.getLast(), "Advertisement frame");
            if (closeAddButton.isDisplayed()) {
                clickElement(closeAddButton, "[Close add] button");
            }
            switchToDefaultContent();
        }
    }

}
