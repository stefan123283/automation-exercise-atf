package com.stefan.automation.managers;

import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public final class KeyboardManager {

    public static void enterValueIntoElement(WebElement webElement, String elementName, String keys) {
        ExplicitWaitManager.waitUntilElementIsVisible(webElement, elementName);
        ScrollManager.scrollToElement(webElement, elementName);
        if (webElement.getTagName().equals("input")) {
            Log.debug("Clearing the value of the \"" + elementName + "\" element");
            webElement.clear();
        }
        webElement.sendKeys(keys);
        Log.debug("Value is entered in the \"" + elementName + "\"");
    }

    public static void pressEnterOnElement(WebElement webElement, String elementName) {
        webElement.sendKeys("\\uE007");
        Log.debug("Pressed \"ENTER\" key on \"" + elementName + "\"");
    }

    public static void pressEnterOnOS() {
        Log.debug("Pressed \"ENTER\" key on OS");
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

}
