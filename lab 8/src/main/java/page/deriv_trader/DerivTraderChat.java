package page.deriv_trader;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

import java.time.Duration;

public class DerivTraderChat extends AbstractPage {
    private final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//iframe[@id='chat-widget']")
    private WebElement chatFrame;
    @FindBy(xpath = "//button[@aria-label='Minimize window']")
    private WebElement minimizeChatWidgetButton;

    public DerivTraderChat(WebDriver driver) {
        super(driver);
    }

    public void closeChatWidget() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.visibilityOf(chatFrame));
            driver.switchTo().frame(chatFrame);
            minimizeChatWidgetButton.click();
            driver.switchTo().defaultContent();
        } catch (TimeoutException ignored) { }
    }
}
