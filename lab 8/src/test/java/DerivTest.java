import com.epam.reportportal.testng.ReportPortalTestNGListener;
import driver.DriverSingleton;
import model.Position;
import model.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.DerivHome;
import page.deriv_trader.DerivTrader;
import service.DerivUserCreator;
import service.TestDataReader;
import util.TestListener;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({TestListener.class, ReportPortalTestNGListener.class})
public class DerivTest {
    private final float takeProfitValue = Float.parseFloat(TestDataReader.getTestData("test_data.deriv_test.take_profit_value"));
    private final float stopLossValue = Float.parseFloat(TestDataReader.getTestData("test_data.deriv_test.stop_loss_value"));
    private final float moneyValue = Float.parseFloat(TestDataReader.getTestData("test_data.deriv_test.money_value"));
    private final int multiplierValue = Integer.parseInt(TestDataReader.getTestData("test_data.deriv_test.multiplier_value"));
    private final String marketName = TestDataReader.getTestData("test_data.deriv_test.market_name");
    private final String templateName = TestDataReader.getTestData("test_data.deriv_test.template_name");
    private final String indicatorName = TestDataReader.getTestData("test_data.deriv_test.indicator_name");

    private DerivTrader tradePage;

    @BeforeMethod
    private void initializeBrowser() {
        User user = DerivUserCreator.getUserWithCredentials();
        tradePage = new DerivHome(DriverSingleton.getDriver())
                .openPage()
                .openLoginPage()
                .login(user)
                .closeChatWidget();
    }

    @Test
    public void putOnRiseWithTakeProfitLimit() {
        Position expectedPosition = new Position(true);
        expectedPosition.setTakeProfit(takeProfitValue);
        Position actualPosition = tradePage
                .createPosition(expectedPosition)
                .getLastCreatedPosition();
        tradePage.closePosition();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("money", "multiplier", "stopLoss", "dealCancellation")
                .isEqualTo(expectedPosition);
    }

    @Test
    public void putOnFallWithStopLossLimit() {
        Position expectedPosition = new Position(false);
        expectedPosition.setStopLoss(stopLossValue);
        Position actualPosition = tradePage
                .createPosition(expectedPosition)
                .getLastCreatedPosition();
        tradePage.closePosition();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("money", "multiplier", "takeProfit", "dealCancellation")
                .isEqualTo(expectedPosition);
    }

    @Test
    public void putOnRiseWithMoneySet() {
        Position expectedPosition = new Position(true);
        expectedPosition.setMoney(moneyValue);
        Position actualPosition = tradePage
                .createPosition(expectedPosition)
                .getLastCreatedPosition();
        tradePage.closePosition();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("stopLoss", "multiplier", "takeProfit", "dealCancellation")
                .isEqualTo(expectedPosition);
    }

    @Test
    public void putOnFallWithMultiplierSet() {
        Position expectedPosition = new Position(true);
        expectedPosition.setMultiplier(multiplierValue);
        Position actualPosition = tradePage
                .createPosition(expectedPosition)
                .getLastCreatedPosition();
        tradePage.closePosition();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("stopLoss", "money", "takeProfit", "dealCancellation")
                .isEqualTo(expectedPosition);
    }

    @Test
    public void putOnRiseWithDealCancellation() {
        Position expectedPosition = new Position(true);
        expectedPosition.setDealCancellation(true);
        Position actualPosition = tradePage
                .createPosition(expectedPosition)
                .getLastCreatedPosition();
        tradePage.cancelPosition();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("stopLoss", "multiplier", "takeProfit", "money")
                .isEqualTo(expectedPosition);
    }

    @Test
    public void isReportSaved() {
        Position expectedPosition = new Position(true);
        expectedPosition.setMoney(moneyValue);
        expectedPosition.setStopLoss(stopLossValue);
        expectedPosition.setTakeProfit(takeProfitValue);
        Position actualPosition = tradePage
                .createPosition(expectedPosition)
                .closePosition()
                .openReportPage()
                .openProfitTable()
                .openLastPosition()
                .getPositionInfo();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("multiplier", "dealCancellation")
                .isEqualTo(expectedPosition);

    }

    @Test
    public void changeCreatedPositionTakeProfitValue() {
        Position expectedPosition = new Position(false);
        tradePage.createPosition(expectedPosition);
        expectedPosition.setTakeProfit(takeProfitValue);
        Position actualPosition = tradePage
                .changeTakeProfitParameterOfOpenedPosition(expectedPosition)
                .getLastCreatedPosition();
        tradePage.closePosition();
        assertThat(actualPosition)
                .usingRecursiveComparison()
                .ignoringFields("multiplier", "dealCancellation", "stopLoss", "money")
                .isEqualTo(expectedPosition);
    }

    @Test
    public void changeMarket() {
        assertThat(
                tradePage
                        .changeMarket(marketName)
                        .getCurrentMarket()
        ).isEqualTo(marketName.toUpperCase());
    }

    @Test
    public void addTemplate() {
        String actualTemplateName = tradePage
                .addNewTemplate(templateName)
                .getSavedTemplateName();
        tradePage.clearTemplates();
        assertThat(actualTemplateName).isEqualTo(templateName);
    }

    @Test
    public void addIndicator() {
        String actualIndicatorName = tradePage
                .addIndicator(indicatorName)
                .getLastIndicatorName();
        tradePage.clearIndicators();
        assertThat(actualIndicatorName).isEqualTo(String.format("\u200C%s\u200C", indicatorName));
    }

    @AfterMethod(alwaysRun = true)
    private void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
