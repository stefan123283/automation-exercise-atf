package com.stefan.automation.managers;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {

    private static final int EXPLICIT_WAIT = Integer.parseInt(ConfigReaderManager.getProperty("explicitWait"));
    private static final WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(EXPLICIT_WAIT));

    public static void waitUntilElementIsVisible(WebElement webElement, String elementName) {
        Log.debug("Waiting \"" + elementName + "\" to be visible (timeout: " + EXPLICIT_WAIT + "s)");
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            Log.error("\"" + elementName + "\" not found (timeout: " + EXPLICIT_WAIT + "s)");
            throw new RuntimeException("\"" + elementName + "\" not found (timeout: " + EXPLICIT_WAIT + "s)", e);
        }
        Log.debug("\"" + elementName + "\" is visible");
    }

    public static void waitUntilElementIsClickable(WebElement webElement, String elementName) {
        Log.debug("Waiting \"" + elementName + "\" to be clickable (timeout: " + EXPLICIT_WAIT + "s)");
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            Log.error("\"" + elementName + "\" is not clickable (timeout: " + EXPLICIT_WAIT + "s)");
            throw new RuntimeException("\"" + elementName + "\" is not clickable (timeout: " + EXPLICIT_WAIT + "s)", e);
        }
        Log.debug("\"" + elementName + "\" is clickable");
    }

}
