package page.deriv_trader.main_field;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;

public class DerivTraderMainFieldTemplate extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class, 'sc-views-menu')]/div[@class='cq-menu-btn']")
    private WebElement openTemplateWindowButton;
    @FindBy(xpath = "//div[contains(@class, 'sc-views__views__list__item')]/div[@class='text']")
    private WebElement savedTemplateText;
    @FindBy(xpath = "//div[@class='sc-views']//button")
    private WebElement addNewTemplateButton;
    @FindBy(xpath = "//input[contains(@class, 'sc-input')]")
    private WebElement searchTemplateInput;
    @FindBy(xpath = "//div[@class='sc-dialog__head--action']/span")
    private WebElement closeTemplateWindowButton;
    @FindBy(xpath = "//div[@class='sc-views__views__head']/button")
    private WebElement clearTemplatesButton;

    DerivTraderMainFieldTemplate(WebDriver driver) {
        super(driver);
    }

    public void addNewTemplate(String templateName) {
        openTemplateWindow();
        waitToElementBeClickable(addNewTemplateButton);
        addNewTemplateButton.click();
        waitToElementBeClickable(searchTemplateInput);
        searchTemplateInput.sendKeys(templateName + Keys.ENTER);
        logger.info(() -> String.format("Added new template with name %s", templateName));
        closeTemplateWindow();
    }

    public String getSavedTemplateName() {
        openTemplateWindow();
        waitToElementBeClickable(savedTemplateText);
        String templateName = savedTemplateText.getText();
        logger.info("Getting saved template name");
        closeTemplateWindow();
        return templateName;
    }

    public void clearTemplates() {
        openTemplateWindow();
        waitToElementBeClickable(clearTemplatesButton);
        clearTemplatesButton.click();
        logger.info("Templates cleared");
        closeTemplateWindow();
    }

    private void openTemplateWindow() {
        waitToElementBeClickable(openTemplateWindowButton);
        openTemplateWindowButton.click();
    }

    private void closeTemplateWindow() {
        waitToElementBeClickable(closeTemplateWindowButton);
        closeTemplateWindowButton.click();
    }
}
