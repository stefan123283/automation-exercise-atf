package com.stefan.automation.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties properties;

    private static void initProperties() {
        Log.debug("Loading test configuration");
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            Log.error("The \"" + CONFIG_FILE_PATH + "\" file was not found or it can't be opened");
            throw new RuntimeException("The \"" + CONFIG_FILE_PATH + "\" file was not found or it can't be opened", e);
        }
        Log.info("Test configuration loaded successfully");
    }

    public static String getProperty(String property) {
        if (properties == null) {
            initProperties();
        }

        if (property == null || property.isBlank()) {
            Log.error("Property can't be null or empty!");
            throw new IllegalArgumentException("Property can't be null or empty!");
        }

        String propertyValue = properties.getProperty(property);

        if (propertyValue == null) {
            Log.error("Property \"" + property + "\" was not found in the test configuration file");
            throw new RuntimeException("Property \"" + property + "\" was not found in the test configuration file");
        } else if (propertyValue.isBlank()) {
            Log.error("Property \"" + property + "\" is empty");
            throw new IllegalArgumentException("Property \"" + property + "\" is empty");
        }

        return propertyValue;
    }

}
