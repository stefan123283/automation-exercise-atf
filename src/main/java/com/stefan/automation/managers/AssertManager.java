package com.stefan.automation.managers;

import org.junit.jupiter.api.Assertions;

public class AssertManager {

    public static void assertTrue(boolean condition, String message) {
        ExtentReportManager.addTestStep(message);
        Assertions.assertTrue(condition, message);
    }

}
