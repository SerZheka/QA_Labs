package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinHome {
    private WebDriver driver;
    private final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    public WebElement newPasteTextArea;
    @FindBy(id = "select2-postform-expiration-container")
    public WebElement pasteExpirationSpan;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    public WebElement pasteExpirationSelect;
    @FindBy(id = "postform-name")
    public WebElement pasteNameSpan;
    @FindBy(xpath = "//button[text()='Create New Paste']")
    public WebElement noteCreateButton;

    public PasteBinHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHome openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteBinHome addNewPasteText(String newPasteText) {
        newPasteTextArea.sendKeys(newPasteText);
        return this;
    }

    public PasteBinHome setPasteExpiration10Minutes() {
        pasteExpirationSpan.click();
        pasteExpirationSelect.click();
        return this;
    }

    public PasteBinHome enterPasteTitle(String pasteTitleText) {
        pasteNameSpan.sendKeys(pasteTitleText);
        return this;
    }

    public PasteBinNote submitCreateNote() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", noteCreateButton);
        noteCreateButton.click();
        return new PasteBinNote(driver);
    }
}

