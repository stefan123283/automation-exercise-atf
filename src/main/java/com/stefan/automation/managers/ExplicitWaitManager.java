package com.stefan.automation.managers;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitManager {

    private static final int EXPLICIT_WAIT = Integer.parseInt(ConfigReaderManager.getProperty("explicitWait"));

    private ExplicitWaitManager() {
    }

    private static WebDriverWait createWait() {
        return new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public static void waitUntilElementIsVisible(WebElement webElement, String elementName) {
        Log.debug("Waiting \"" + elementName + "\" to be visible (timeout: " + EXPLICIT_WAIT + "s)");
        try {
            createWait().until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            Log.error("\"" + elementName + "\" is not visible");
            throw new IllegalStateException("\"" + elementName + "\" is not visible", e);
        }
        Log.debug("\"" + elementName + "\" is visible");
    }

    public static boolean checkIfElementIsVisible(WebElement webElement, String elementName) {
        Log.debug("Checking if \"" + elementName + "\" is visible (timeout : " + EXPLICIT_WAIT + "s)");
        try {
            createWait().until(ExpectedConditions.visibilityOf(webElement));
            Log.debug("\"" + elementName + "\" is visible");
            return true;
        } catch (TimeoutException e) {
            Log.debug("\"" + elementName + "\" is not visible");
            return false;
        }
    }

    public static void waitUntilElementIsClickable(WebElement webElement, String elementName) {
        Log.debug("Waiting \"" + elementName + "\" to be clickable (timeout: " + EXPLICIT_WAIT + "s)");
        try {
            createWait().until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException e) {
            Log.error("\"" + elementName + "\" is not clickable");
            throw new IllegalStateException("\"" + elementName + "\" is not clickable", e);
        }
        Log.debug("\"" + elementName + "\" is clickable");
    }

    public static void waitUntilAlertIsVisible() {
        Log.debug("Waiting JavaScript alert to be visible (timeout: " + EXPLICIT_WAIT + "s)");
        try {
            createWait().until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            Log.error("JavaScript alert is not visible");
            throw new IllegalStateException("JavaScript alert is not visible", e);
        }
        Log.debug("JavaScript alert is visible");
    }

    public static boolean checkIfElementIsNotVisible(WebElement webElement, String elementName) {
        Log.debug("Checking if \"" + elementName + "\" is not visible (timeout : " + EXPLICIT_WAIT + "s)");
        try {
            createWait().until(ExpectedConditions.invisibilityOf(webElement));
            Log.debug("\"" + elementName + "\" is not visible");
            return true;
        } catch (TimeoutException e) {
            Log.debug("\"" + elementName + "\" is still visible");
            return false;
        }
    }

}
