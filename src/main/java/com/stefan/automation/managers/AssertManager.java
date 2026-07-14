package com.stefan.automation.managers;

import org.junit.jupiter.api.Assertions;

public class AssertManager {

    public static void assertTrue(boolean condition, String message) {
        Assertions.assertTrue(condition, message);
        ExtentReportManager.addTestStep(message);
        Log.info(message);
    }

}
