package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DerivLogin extends AbstractPage {
    private final By locatorLoginInput = By.id("txtEmail");

    @FindBy(id = "txtPass")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement signInButton;

    public DerivLogin(WebDriver driver) {
        super(driver);
    }

    public DerivLogin enterLogin(String login) {
        WebElement loginInput = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(locatorLoginInput));
        loginInput.sendKeys(login);
        return this;
    }

    public DerivLogin enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public DerivTrader signIn() {
        signInButton.click();
        return new DerivTrader(driver);
    }
}
