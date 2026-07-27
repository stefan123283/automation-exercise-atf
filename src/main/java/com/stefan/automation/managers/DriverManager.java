package com.stefan.automation.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class DriverManager {

    private static final String BROWSER_TYPE = ConfigReaderManager.getProperty("browserType");
    private static final String INCOGNITO_MODE = ConfigReaderManager.getProperty("incognitoMode");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (BROWSER_TYPE.toUpperCase()) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();
                if (INCOGNITO_MODE.equals("enabled")) {
                    options.addArguments("--incognito");
                    Log.info("Initiating Chrome driver instance with incognito mode enabled");
                } else {
                    Log.info("Initiating Chrome driver instance with incognito mode disabled");
                }
                driver = new ChromeDriver(options);
            }
            case "EDGE" -> {
                EdgeOptions options = new EdgeOptions();
                if (INCOGNITO_MODE.equals("enabled")) {
                    options.addArguments("--incognito");
                    Log.info("Initiating Edge driver instance with incognito mode enabled");
                } else {
                    Log.info("Initiating Edge driver instance with incognito mode disabled");
                }
                driver = new EdgeDriver(options);
            }
            case "FIREFOX" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (INCOGNITO_MODE.equals("enabled")) {
                    options.addArguments("--incognito");
                    Log.info("Initiating FireFox driver instance with incognito mode enabled");
                } else {
                    Log.info("Initiating FireFox driver instance with incognito mode disabled");
                }
                driver = new FirefoxDriver(options);
            }
            default -> {
                Log.error("Invalid browser name specified!");
                throw new IllegalArgumentException("Invalid browser name specified!");
            }
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

    public void quitTheDriver() {
        Log.info("Closing browser session");
        driver.quit();
        driver = null;
        instance = null;
    }

}
