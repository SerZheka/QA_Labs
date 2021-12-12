package page;

import model.Position;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DerivContractInfo extends AbstractPage{
    @FindBy(xpath = "//div[@class='dc-contract-type']/div[contains(@class, 'type-label')]/div")
    private WebElement positionUp;
    @FindBy(xpath = "//div[@class='dc-contract-type']/div[contains(@class, 'type-label')]/div[contains(@class, 'multiplier')]")
    private WebElement positionMultiplier;
    @FindBy(xpath = "//div[@class='dc-contract-card-items-wrapper']/div[contains(@class, 'stake')]/div[contains(@class, 'body')]/*")
    private WebElement positionStake;
    @FindBy(xpath = "//div[@class='dc-contract-card-items-wrapper']/div[contains(@class, 'deal-cancel-fee')]/div[contains(@class, 'body')]/*")
    private WebElement positionDealCancellation;
    @FindBy(xpath = "//div[@class='dc-contract-card-items-wrapper']//div[contains(@class, 'take-profit')]/div[contains(@class, 'body')]/*")
    private WebElement positionTakeProfit;
    @FindBy(xpath = "//div[@class='dc-contract-card-items-wrapper']//div[contains(@class, 'stop-loss')]/div[contains(@class, 'body')]/*")
    private List<WebElement> positionStopLoss;

    public DerivContractInfo(WebDriver driver) {
        super(driver);
    }

    public Position getPositionInfo() {
        Position position = getPosition();
        setMoney(position);
        setDealCancellation(position);
        setTakeProfit(position);
        setStopLoss(position);
        setMultiplier(position);
        logger.info(() -> String.format("Position info: %s", position));
        return position;
    }

    private void setMultiplier(Position position) {
        position.setMultiplier(Integer.parseInt(
                positionMultiplier.getText()
                        .replace("x", "")));
    }

    private void setStopLoss(Position position) {
        try {
            position.setStopLoss(Float.parseFloat(positionStopLoss.get(1).getText()));
        } catch (NumberFormatException | IndexOutOfBoundsException ignored) { }
    }

    private void setTakeProfit(Position position) {
        String takeProfit = positionTakeProfit.getText();
        if (!takeProfit.equals("-"))
            position.setTakeProfit(Float.parseFloat(takeProfit));
    }

    private void setDealCancellation(Position position) {
        position.setDealCancellation(
                !positionDealCancellation.getText()
                        .equals("-"));
    }

    private void setMoney(Position position) {
        position.setMoney(
                Float.parseFloat(positionStake.getText()));
    }

    private Position getPosition() {
        waitToElementBeClickable(positionUp);
        return new Position(
                positionUp.getText()
                        .equals("Up"));
    }
}
