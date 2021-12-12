package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.deriv_trader.DerivTrader;

public class DerivLogin extends AbstractPage {
    @FindBy(id = "txtEmail")
    private WebElement loginInput;
    @FindBy(id = "txtPass")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement signInButton;

    public DerivLogin(WebDriver driver) {
        super(driver);
    }

    public DerivTrader login(User user) {
        waitToElementBeClickable(loginInput);
        loginInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        signInButton.click();
        logger.info("Login performed");
        return new DerivTrader(driver);
    }
}
