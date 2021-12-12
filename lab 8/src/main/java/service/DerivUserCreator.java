package service;

import model.User;

public class DerivUserCreator {
    private static final String TEST_DATA_USER_NAME = "test_data.user.name";
    private static final String TEST_DATA_PASSWORD = "test_data.user.password";

    public static User getUserWithCredentials() {
        return new User(TestDataReader.getTestData(TEST_DATA_USER_NAME),
                TestDataReader.getTestData(TEST_DATA_PASSWORD));
    }
}
