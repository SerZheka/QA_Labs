package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.SeleniumHomePage;

import java.time.Duration;

public class SeleniumDevTest {
    private WebDriver driver;

    private final String expectedDownloadButtonText = "Downloads";

    @BeforeMethod(alwaysRun = true)
    public void initializeBrowser() {
        driver = new OperaDriver();
    }

    @Test
    public void searchDownloadLink() {
        driver.get("https://selenium.dev");
        WebElement searchInput = driver.findElement(By.xpath("//*[@type='search']"));
        searchInput.sendKeys("ide");
        WebElement downloadButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/nav/div/ul/li[3]/a")));
        Assert.assertEquals(downloadButton.getText(), expectedDownloadButtonText);
    }

    @Test
    public void searchDownloadLinkWithPO() {
        String textOfDownloadButton = new SeleniumHomePage(driver)
                .openPage()
                .searchForTerms("ide")
                .getTextOfDownloadButton();
        Assert.assertEquals(textOfDownloadButton, expectedDownloadButtonText);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
