package page.deriv_trader.main_field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

import java.time.Duration;

public class DerivTraderMainFieldMarket extends AbstractPage {
    private static final String MARKET_NAME_LOCATOR_PATTERN = "//div[text()= '%s' and @class='sc-mcd__item__name']/parent::div";

    @FindBy(xpath = "//div[contains(@class, 'cq-chart-title')]/div[@class='cq-menu-btn']")
    private WebElement changeMarketButton;
    @FindBy(xpath = "//div[contains(@class, 'cq-menu-dropdown')]//input[@class='data-hj-whitelist']")
    private WebElement searchMarketInput;
    @FindBy(xpath = "//div[@class='cq-symbol-select-btn']//div[@class='cq-symbol']")
    private WebElement marketNameField;

    DerivTraderMainFieldMarket(WebDriver driver) {
        super(driver);
    }

    public void changeMarket(String marketName) {
        waitToElementBeClickable(changeMarketButton);
        changeMarketButton.click();
        waitToElementBeClickable(searchMarketInput);
        searchMarketInput.sendKeys(marketName);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(String.format(MARKET_NAME_LOCATOR_PATTERN, marketName.toUpperCase()))))
                .click();
        logger.info(() -> String.format("Market changed to %s", marketName));
    }

    public String getCurrentMarket() {
        waitToElementBeClickable(marketNameField);
        logger.info("Getting current market name");
        return marketNameField.getText();
    }
}
