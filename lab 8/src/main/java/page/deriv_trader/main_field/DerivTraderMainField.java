package page.deriv_trader.main_field;

import org.openqa.selenium.WebDriver;
import page.AbstractPage;

public class DerivTraderMainField extends AbstractPage {
    private final DerivTraderMainFieldMarket market;
    private final DerivTraderMainFieldIndicator indicator;
    private final DerivTraderMainFieldTemplate template;

    public DerivTraderMainField(WebDriver driver) {
        super(driver);
        market = new DerivTraderMainFieldMarket(driver);
        indicator = new DerivTraderMainFieldIndicator(driver);
        template = new DerivTraderMainFieldTemplate(driver);
    }

    public void changeMarket(String marketName) {
        market.changeMarket(marketName);
    }

    public String getCurrentMarket() {
        return market.getCurrentMarket();
    }

    public void addIndicator(String indicatorName) {
        indicator.addIndicator(indicatorName);
    }

    public String getLastIndicatorName() {
        return indicator.getLastIndicatorName();
    }

    public void clearIndicators() {
        indicator.clearIndicators();
    }

    public void addNewTemplate(String templateName) {
        template.addNewTemplate(templateName);
    }

    public String getSavedTemplateName() {
        return template.getSavedTemplateName();
    }

    public void clearTemplates() {
        template.clearTemplates();
    }
}
