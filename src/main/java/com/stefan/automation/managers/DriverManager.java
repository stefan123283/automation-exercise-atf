package com.stefan.automation.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static final String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                Log.info("Initiating the Chrome driver instance...");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                Log.info("Initiating the Edge driver instance...");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                Log.info("Initiating the Firefox driver instance...");
                break;
        }
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }

}
