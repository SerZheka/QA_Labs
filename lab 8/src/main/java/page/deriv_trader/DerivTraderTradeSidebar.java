package page.deriv_trader;

import model.Position;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

import java.time.Duration;

public class DerivTraderTradeSidebar extends AbstractPage {
    private static final String MULTIPLIER_LOCATOR_PATTERN = "//div[contains(@class, 'trade-container__multiplier-dropdown')]//div[@id='%d']";

    @FindBy(xpath = "//label[contains(@class, 'take_profit-checkbox')]/span[@class='dc-checkbox__box']")
    private WebElement takeProfitCheckbox;
    @FindBy(id = "dc_take_profit_input")
    private WebElement takeProfitInput;
    @FindBy(xpath = "//label[contains(@class, 'stop_loss-checkbox')]/span[@class='dc-checkbox__box']")
    private WebElement stopLossCheckbox;
    @FindBy(id = "dc_stop_loss_input")
    private WebElement stopLossInput;
    @FindBy(xpath = "//label[@for='dt_cancellation-checkbox_input']/span[@class='dc-checkbox__box']")
    private WebElement dealCancellationCheckbox;
    @FindBy(id = "dt_amount_input")
    private WebElement moneyInput;
    @FindBy(id = "dt_purchase_multup_button")
    private WebElement riseButton;
    @FindBy(id = "dt_purchase_multdown_button")
    private WebElement fallButton;
    @FindBy(xpath = "//div[contains(@class, 'trade-container__multiplier-dropdown')]//div[@id='dropdown-display']")
    private WebElement multiplierDropdown;

    DerivTraderTradeSidebar(WebDriver driver) {
        super(driver);
    }

    public void createPosition(Position position) {
        if (position.getMoney() != 0)
            setMoney(position.getMoney());
        if (position.getStopLoss() != 0)
            setStopLossLimit(position.getStopLoss());
        if (position.getTakeProfit() != 0)
            setTakeProfitLimit(position.getTakeProfit());
        if (position.isDealCancellation())
            setDealCancellation();
        if (position.getMultiplier() != 0)
            setMultiplier(position.getMultiplier());
        if (position.isUp())
            putOnRise();
        else
            putOnFall();
    }

    private void setTakeProfitLimit(float takeProfitLimit) {
        waitToElementBeClickable(takeProfitCheckbox);
        takeProfitCheckbox.click();
        waitToElementBeClickable(takeProfitInput);
        takeProfitInput.sendKeys(Float.toString(takeProfitLimit));
        logger.info(() -> String.format("Take profit set to %.2f", takeProfitLimit));
    }

    private void setStopLossLimit(float stopLossLimit) {
        waitToElementBeClickable(stopLossCheckbox);
        stopLossCheckbox.click();
        waitToElementBeClickable(stopLossInput);
        stopLossInput.sendKeys(Float.toString(stopLossLimit));
        logger.info(() -> String.format("Stop loss set to %.2f", stopLossLimit));
    }

    private void setMoney(float money) {
        waitToElementBeClickable(moneyInput);
        moneyInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        moneyInput.sendKeys(Float.toString(money));
        logger.info(() -> String.format("Money set to %.2f", money));
    }

    private void setDealCancellation() {
        waitToElementBeClickable(dealCancellationCheckbox);
        dealCancellationCheckbox.click();
        logger.info("Deal cancellation set");
    }

    private void setMultiplier(int multiplier) {
        waitToElementBeClickable(multiplierDropdown);
        multiplierDropdown.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(String.format(MULTIPLIER_LOCATOR_PATTERN, multiplier))))
                .click();
        logger.info(() -> String.format("Multiplier set to %d", multiplier));
    }

    private void putOnRise() {
        waitToElementBeClickable(riseButton);
        riseButton.click();
        waitToElementBeClickable(riseButton);
        logger.info("Up position created");
    }

    private void putOnFall() {
        waitToElementBeClickable(fallButton);
        fallButton.click();
        waitToElementBeClickable(fallButton);
        logger.info("Down position created");
    }
}
