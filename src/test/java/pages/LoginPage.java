package pages;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.InputData;

public class LoginPage extends AbstractPage {
    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(xpath = "//input[@type='email']")
    private  WebElement login;

    @FindBy(xpath = "//input[@type='password']")
    private  WebElement passwordInput;

    @FindBy(id = "identifierNext")
    private WebElement loginNextBtn;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextBtn;

    @FindBy(xpath= "//img[@class='gb_Ka gbii']")
    private WebElement userName;

    @FindBy(xpath="//a[contains(text(),'Выйти')]")
    private WebElement logoutBtn;

    public LoginPage(WebDriver driver){
        super (driver);
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(login));
    }

    public LoginPage login(User testUser) {
        login.sendKeys(testUser.getUsername());
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(loginNextBtn));
        loginNextBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(testUser.getPassword());
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(passwordNextBtn));
        passwordNextBtn.click();


        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));

        return this;
    }

    public String getLoggedUserName(){
        userName.click();
        WebElement result = driver.findElement(By.xpath("//*[@class='gb_vb']"));
        return result.getText();
    }

    public String logoutUser(){
        userName.click();
        logoutBtn.click();
        WebElement result = driver.findElement(By.id("profileIdentifier"));
        return result.getText();
    }

}
