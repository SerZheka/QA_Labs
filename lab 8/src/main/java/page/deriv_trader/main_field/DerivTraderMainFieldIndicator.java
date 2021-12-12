package page.deriv_trader.main_field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class DerivTraderMainFieldIndicator extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'sc-studies')]/div[@class='cq-menu-btn']")
    private WebElement openIndicatorButton;
    @FindBy(xpath = "//div[@class='sc-dialog__head--action']/span")
    private WebElement closeIndicatorButton;
    @FindBy(xpath = "//div[@class='sc-dialog__head']//div[@class='sc-search-input']/input")
    private WebElement searchIndicatorInput;
    @FindBy(xpath = "//div[@class='sc-studies__list__item ']//div[@class='info']")
    private WebElement addIndicatorButton;
    @FindBy(xpath = "//div[@class='sc-studies__list__item ']//div[@class='text']/span")
    private WebElement indicatorText;
    @FindBy(xpath = "//div[@class='sc-studies__panel__head']/button")
    private WebElement clearIndicatorsButton;

    DerivTraderMainFieldIndicator(WebDriver driver) {
        super(driver);
    }

    public void addIndicator(String indicatorName) {
        openIndicatorWindow();
        waitToElementBeClickable(searchIndicatorInput);
        searchIndicatorInput.sendKeys(indicatorName);
        waitToElementBeClickable(addIndicatorButton);
        addIndicatorButton.click();
        logger.info(() -> String.format("Added indicator with name %s", indicatorName));
        closeIndicatorWindow();
    }

    public String getLastIndicatorName() {
        openIndicatorWindow();
        waitToElementBeClickable(indicatorText);
        String indicatorName = indicatorText.getText();
        logger.info("Getting active indicator");
        closeIndicatorWindow();
        return indicatorName;
    }

    public void clearIndicators() {
        openIndicatorWindow();
        waitToElementBeClickable(clearIndicatorsButton);
        clearIndicatorsButton.click();
        logger.info("Indicators cleared");
        closeIndicatorWindow();
    }

    private void openIndicatorWindow() {
        waitToElementBeClickable(openIndicatorButton);
        openIndicatorButton.click();
    }

    private void closeIndicatorWindow() {
        waitToElementBeClickable(closeIndicatorButton);
        closeIndicatorButton.click();
    }
}
