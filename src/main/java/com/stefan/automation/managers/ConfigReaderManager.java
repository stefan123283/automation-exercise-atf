package com.stefan.automation.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties properties;

    private static void initProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            Log.info("The configuration file was not found or it can't be opened");
        }
    }

    public static String getProperty(String property) {
        Log.info("Reading the \"" + property + "\" property from the \"" + CONFIG_FILE_PATH + "\" file");
        if (properties == null) {
            initProperties();
        }
        return properties.getProperty(property);
    }

}
