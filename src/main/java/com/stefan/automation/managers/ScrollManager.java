package com.stefan.automation.managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public final class ScrollManager {

    private ScrollManager() {
    }

    private static JavascriptExecutor getJavaScriptExecutor() {
        return (JavascriptExecutor) DriverManager.getInstance().getDriver();
    }

    public static void scrollToBottomOfPage() {
        Log.debug("Scrolling to bottom of the page");
        getJavaScriptExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToElement(WebElement webElement, String elementName) {
        Log.debug("Scrolling to " + elementName + " element");
        getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void scrollToTopOfPage() {
        Log.debug("Scrolling to top of the page");
        getJavaScriptExecutor().executeScript("window.scrollTo(0, 0);");
    }
}
