package page.deriv_trader;

import model.Position;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.DerivContractInfo;

public class DerivTraderOpenedPosition extends AbstractPage {
    @FindBy(xpath = "//button[contains(@id, 'dc_contract_card') and contains(@class, 'dc-btn--sell')]")
    private WebElement closePositionButton;
    @FindBy(xpath = "//button[contains(@id, 'dc_contract_card') and contains(@class, 'dc-btn--cancel')]")
    private WebElement cancelPositionButton;
    @FindBy(className = "dc-contract-card-dialog-toggle")
    private WebElement changeParametersOfOpenedPositionButton;
    @FindBy(xpath = "//div[contains(@class, 'dc-contract-card-dialog--enter-done')]//label[contains(@class, 'contract_update_take_profit-checkbox')]/span[@class='dc-checkbox__box']")
    private WebElement takeProfitOnOpenedPositionCheckbox;
    @FindBy(id = "dc_contract_update_take_profit_input")
    private WebElement takeProfitOnOpenedPositionInput;
    @FindBy(xpath = "//div[@class='dc-contract-card-dialog__button']/button[@type='submit']")
    private WebElement submitChangeOfOpenedPositionButton;

    DerivTraderOpenedPosition(WebDriver driver) {
        super(driver);
    }

    public void changeTakeProfitParameterOfOpenedPosition(Position position) {
        openChangingParametersOfOpenedPosition();
        if (position.getTakeProfit() != 0) {
            waitToElementBeClickable(takeProfitOnOpenedPositionCheckbox);
            takeProfitOnOpenedPositionCheckbox.click();
            waitToElementBeClickable(takeProfitOnOpenedPositionInput);
            takeProfitOnOpenedPositionInput.sendKeys(Float.toString(position.getTakeProfit()));
        }
        submitChangingParametersOfOpenedPosition();
        logger.info("Position parameters changed");
    }

    public void cancelPosition() {
        waitToElementBeClickable(cancelPositionButton);
        cancelPositionButton.click();
        logger.info("Position cancelled");
    }

    public void closePosition() {
        waitToElementBeClickable(closePositionButton);
        closePositionButton.click();
        logger.info("Position closed");
    }

    public Position getLastCreatedPosition() {
        return new DerivContractInfo(driver).getPositionInfo();
    }

    private void openChangingParametersOfOpenedPosition() {
        waitToElementBeClickable(changeParametersOfOpenedPositionButton);
        changeParametersOfOpenedPositionButton.click();
    }

    private void submitChangingParametersOfOpenedPosition() {
        waitToElementBeClickable(submitChangeOfOpenedPositionButton);
        submitChangeOfOpenedPositionButton.click();
        waitToElementBeClickable(changeParametersOfOpenedPositionButton);
    }
}
