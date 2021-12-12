package data_provider;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {
    @DataProvider
    public static Object[][] sumDataProvider() {
        return new Object[][]{{1, 2, 3}, {4, 6, 10}};
    }

    @DataProvider
    public static Object[][] differenceDataProvider() {
        return new Object[][]{{7, 2, 5}, {90, 50, 40}};
    }

    @DataProvider
    public static Object[][] multiplicationDataProvider() {
        return new Object[][]{{2, 3, 6}, {8, 4, 32}};
    }

    @DataProvider
    public static Object[][] divisionDataProvider() {
        return new Object[][]{{6, 3, 2}, {80, 8, 10}};
    }

    @DataProvider
    public static Object[][] divisionByZeroDataProvider() {
        return new Object[][]{{5, 0}};
    }
}
