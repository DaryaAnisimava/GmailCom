package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    protected final int WAIT_TIMEOUTS_SECONDS = 25;

    protected AbstractPage(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
