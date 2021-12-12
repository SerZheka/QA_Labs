package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DerivHome extends AbstractPage {
    private static final String HOME_PAGE_URL = "https://deriv.com";

    @FindBy(id = "dm-nav-login-button")
    private WebElement loginButton;

    public DerivHome(WebDriver driver) {
        super(driver);
    }

    public DerivHome openPage() {
        driver.get(HOME_PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public DerivLogin openLoginPage() {
        loginButton.click();
        logger.info("Login page opened");
        return new DerivLogin(driver);
    }
}
