package page.deriv_trader;

import model.Position;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.DerivReport;
import page.deriv_trader.main_field.DerivTraderMainField;

public class DerivTrader extends AbstractPage {
    private final DerivTraderTradeSidebar tradeSidebar;
    private final DerivTraderOpenedPosition openedPosition;
    private final DerivTraderMainField mainField;
    private final DerivTraderChat chat;

    @FindBy(id = "dt_reports_tab")
    private WebElement reportPageLink;

    public DerivTrader(WebDriver driver) {
        super(driver);
        tradeSidebar = new DerivTraderTradeSidebar(driver);
        openedPosition = new DerivTraderOpenedPosition(driver);
        mainField = new DerivTraderMainField(driver);
        chat = new DerivTraderChat(driver);
    }

    public DerivReport openReportPage() {
        reportPageLink.click();
        logger.info("Report page opened");
        return new DerivReport(driver);
    }

    public DerivTrader changeTakeProfitParameterOfOpenedPosition(Position position) {
        openedPosition.changeTakeProfitParameterOfOpenedPosition(position);
        return this;
    }

    public DerivTrader closePosition() {
        openedPosition.closePosition();
        return this;
    }

    public void cancelPosition() {
        openedPosition.cancelPosition();
    }

    public Position getLastCreatedPosition() {
        return openedPosition.getLastCreatedPosition();
    }

    public DerivTrader changeMarket(String marketName) {
        mainField.changeMarket(marketName);
        return this;
    }

    public String getCurrentMarket() {
        return mainField.getCurrentMarket();
    }

    public DerivTrader addNewTemplate(String templateName) {
        mainField.addNewTemplate(templateName);
        return this;
    }

    public String getSavedTemplateName() {
        return mainField.getSavedTemplateName();
    }

    public void clearTemplates() {
        mainField.clearTemplates();
    }
    public DerivTrader addIndicator(String indicatorName) {
        mainField.addIndicator(indicatorName);
        return this;
    }

    public String getLastIndicatorName() {
        return mainField.getLastIndicatorName();
    }

    public void clearIndicators() {
        mainField.clearIndicators();
    }

    public DerivTrader createPosition(Position position) {
        tradeSidebar.createPosition(position);
        return this;
    }

    public DerivTrader closeChatWidget() {
        chat.closeChatWidget();
        return this;
    }
}
