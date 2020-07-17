package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage extends AbstractPage{

    @FindBy(xpath= "//*[@class='gb_Ua gb_nd gb_Pg gb_i gb_1f gb_na']")
    private WebElement userName;

    @FindBy(xpath = "//*[text()='Написать']")
    private WebElement composeBtn;

    @FindBy(name = "to")
    private WebElement recipientInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(id = ":vx")
    private WebElement mainTextInput;

    @FindBy(xpath = "//div[contains(text(), 'Отправить')]")
    private WebElement sendButton;

    @FindBy(xpath = "//*[@title='Входящие']")
    private  WebElement inboxFolder;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(String recipient, String subject){
        composeBtn.click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Отправить')]")));
        recipientInput.sendKeys(recipient);
        subjectInput.sendKeys(subject);
        sendButton.click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Письмо отправлено.']")));
    }

    public int checkSentMail() {
        inboxFolder.click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Несортированные']")));
        List<WebElement> sentMails = driver.findElements(By.xpath("//span[text()='test subject']"));
        return sentMails.size();
    }
}


