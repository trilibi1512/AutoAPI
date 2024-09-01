package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static final String PROPERTIES_FILE = "src/main/resources/.editorconfig.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception gracefully based on your application's needs } } public static String getValue(String key) { return properties.getProperty(key); }
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}
