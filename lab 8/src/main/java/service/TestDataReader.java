package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "main_environment"));
    private static final ResourceBundle resourceBundleUsers = ResourceBundle.getBundle(System.getProperty("environment", "user_main"));

    private TestDataReader() { }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    public static String getUserData(String key) {
        return resourceBundleUsers.getString(key);
    }
}
