package com.stefan.automation.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static final String webDriverType = ConfigReaderManager.getProperty("browserType");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                Log.info("Initiating the Chrome driver instance...");
            }
            case "EDGE" -> {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--incognito");
                driver = new EdgeDriver(options);
                Log.info("Initiating the Edge driver instance...");
            }
            case "FIREFOX" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--incognito");
                driver = new FirefoxDriver(options);
                Log.info("Initiating the Firefox driver instance...");
            }
            default -> Log.warn("Invalid browser name specified!");
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
        Log.info("Closing the browser and setting the session to null...");
        driver.quit();
        driver = null;
        instance = null;
    }

}
