package com.stefan.automation.pageobjects;

import com.stefan.automation.managers.ExplicitWaitManager;
import com.stefan.automation.managers.Log;
import com.stefan.automation.managers.ScrollManager;
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

    @FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
    WebElement subscriptionSectionSuccessMessage;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    WebElement deleteAccountButton;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    WebElement loggedInAsUserLink;

    @FindBy(xpath = "//a[contains(text(), 'Test Cases')]")
    WebElement testCasesButton;

    protected void clickElement(WebElement webElement, String elementName) {
        ExplicitWaitManager.waitUntilElementIsClickable(webElement, elementName);
        ScrollManager.scrollToElement(webElement, elementName);
        try {
            webElement.click();
        } catch (ElementClickInterceptedException e) {
            Log.debug("Click intercepted for " + elementName + ". Trying JavaScript click");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        }
        Log.debug("\"" + elementName + "\" is clicked");
    }

    protected void switchToFrame(WebElement frame, String frameName) {
        Log.debug("Switching to \"" + frameName + "\" context");
        driver.switchTo().frame(frame);
    }

    protected void switchToDefaultContent() {
        Log.debug("Switching back to the main page context");
        driver.switchTo().defaultContent();
    }

    protected void acceptAlert() {
        ExplicitWaitManager.waitUntilAlertIsVisible();
        Log.debug("Accepting the Javascript alert");
        driver.switchTo().alert().accept();
    }

    protected String getElementAttributeValue(WebElement webElement, String elementName, String attributeName) {
        Log.debug("The value of the attribute \"" + attributeName + "\" of the \"" + elementName + "\" element is: \"" + webElement.getAttribute(attributeName) + "\"");
        return webElement.getAttribute(attributeName);
    }

    public void closePopUpAddIfPresent() {
        int initialAdsFrameCount = driver.findElements(By.xpath("//iframe[@title='Advertisement']")).size();
        Log.debug("Initial ads frames displayed: " + initialAdsFrameCount);
        for (int i = 0; i < initialAdsFrameCount; i++) {
            List<WebElement> currentAdsFrameList = driver.findElements(By.xpath("//iframe[@title='Advertisement']"));
            int currentAdsFrameCount = currentAdsFrameList.size();
            Log.debug("Current ads frames displayed: " + currentAdsFrameCount);
            if (i >= currentAdsFrameCount) {
                break;
            }
            switchToFrame(currentAdsFrameList.get(i), "Advertisement frame " + (i + 1));
            List<WebElement> closeButtonsList = driver.findElements(By.xpath("//div[text()='Close']"));
            Log.debug("The size of the close buttons list: " + closeButtonsList.size());
            if (!closeButtonsList.isEmpty()) {
                try {
                    clickElement(closeButtonsList.getFirst(), "[Close ad] button");
                    break;
                } catch (IllegalStateException e) {
                    Log.debug("The [Close ad] button is actually not visible");
                } finally {
                    switchToDefaultContent();
                }
            }
            switchToDefaultContent();
        }
    }
}
