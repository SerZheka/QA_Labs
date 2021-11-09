package page;

import org.openqa.selenium.WebDriver;

public class PasteBinNote {
    private WebDriver driver;

    public PasteBinNote(WebDriver driver) {
        this.driver = driver;
    }

    public String noteId() {
        return driver.getCurrentUrl().replace("https://pastebin.com/", "");
    }
}
