package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PasteBinHome;

public class PasteBinTest {
    private WebDriver driver;

    @BeforeMethod
    private void initializeBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void iCanWinTest() {
        String noteId =  new PasteBinHome(driver)
                .openPage()
                .addNewPasteText("Hello from WebDriver")
                .setPasteExpiration10Minutes()
                .enterPasteTitle("helloweb")
                .submitCreateNote()
                .noteId();
        System.out.println(noteId);
        Assert.assertNotNull(noteId);
    }

    @AfterMethod
    private void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
