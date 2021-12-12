package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DerivReport extends AbstractPage {
    @FindBy(id = "dc_profit-table_link")
    private WebElement profitTableLink;
    @FindBy(xpath = "//a[contains(@id, 'dt_reports_contract')]")
    private WebElement lastContractLink;

    public DerivReport(WebDriver driver) {
        super(driver);
    }

    public DerivReport openProfitTable() {
        waitToElementBeClickable(profitTableLink);
        profitTableLink.click();
        logger.info("Profit table section opened");
        return this;
    }

    public DerivContractInfo openLastPosition() {
        waitToElementBeClickable(lastContractLink);
        lastContractLink.click();
        logger.info("Navigate to last contract page");
        return new DerivContractInfo(driver);
    }
}
