package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DerivTrader extends AbstractPage {
    private final By locatorContainerForPositions = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/*");
    private final By locatorRiseButton = By.id("dt_purchase_call_button");

    @FindBy(id = "dt_duration_range_input")
    private WebElement durationSlider;

    public DerivTrader(WebDriver driver) {
        super(driver);
    }

    public DerivTrader setDuration(int duration) {
        int minValue = Integer.parseInt(durationSlider.getAttribute("min"));
        int maxValue = Integer.parseInt(durationSlider.getAttribute("max"));
        int width = durationSlider.getSize().width;
        new Actions(driver)
                .moveToElement(durationSlider,
                        // default value of slider in the middle, so it's needed to move it to start and add required number of steps
                        (int) ((float) (duration - 1) * width / (maxValue - minValue + 1) - (float) width / 2),
                        0)
                .click()
                .build()
                .perform();
        return this;
    }

    public DerivTrader putOnRise() {
        WebElement riseButton = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(locatorRiseButton));
        riseButton.click();
        return this;
    }

    public boolean checkCreatedPosition() {
        List<WebElement> containerForPositions = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorContainerForPositions));
        if (containerForPositions == null) return false;
        return containerForPositions.size() > 0;
    }
}
