package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumHomePage {
    private static final String HOMEPAGE_URL = "https://selenium.dev";
    private WebDriver driver;

    private final String searchInputXPath = "//*[@type='search']";
    @FindBy (xpath = searchInputXPath)
    private WebElement searchInput;
    @FindBy (xpath = "/html/body/header/nav/div/ul/li[3]/a")
    private WebElement downloadButton;

    public SeleniumHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SeleniumHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SeleniumHomePage searchForTerms(String term) {
        searchInput.sendKeys(term);
        return this;
    }

    public String getTextOfDownloadButton() {
        return downloadButton.getText();
    }
}
