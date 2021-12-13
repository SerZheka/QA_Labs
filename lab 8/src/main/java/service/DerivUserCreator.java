package service;

import model.User;

public class DerivUserCreator {
    private static final String TEST_DATA_USER_NAME = "test_data.user.name";
    private static final String TEST_DATA_PASSWORD = "test_data.user.password";

    private DerivUserCreator() { }

    public static User getUserWithCredentials() {
        return new User(TestDataReader.getUserData(TEST_DATA_USER_NAME),
                TestDataReader.getUserData(TEST_DATA_PASSWORD));
    }
}
