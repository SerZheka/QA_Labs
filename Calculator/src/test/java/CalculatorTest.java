import dataProvider.CalculatorDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test(dataProvider = "sumDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void sumTest(int firstTerm, int secondTerm, int expectedResult) {
        Assert.assertEquals(Calculator.getSum(firstTerm, secondTerm), expectedResult);
    }

    @Test(dataProvider = "differenceDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void differenceTest(int firstTerm, int secondTerm, int expectedResult) {
        Assert.assertEquals(Calculator.getDifference(firstTerm, secondTerm), expectedResult);
    }

    @Test(dataProvider = "multiplicationDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void multiplicationTest(int multiplier, int multiplicand, int expectedResult) {
        Assert.assertEquals(Calculator.getMultiplication(multiplier, multiplicand), expectedResult);
    }

    @Test(dataProvider = "divisionDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void divisionTest(int dividend, int divisor, int expectedResult) {
        Assert.assertEquals(Calculator.getDivision(dividend, divisor), expectedResult);
    }

    @Test(dataProvider = "divisionByZeroDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void divisionByZeroTest(int dividend, int divisor) {
        Assert.expectThrows(ArithmeticException.class, () -> Calculator.getDivision(dividend, divisor));
    }
}
