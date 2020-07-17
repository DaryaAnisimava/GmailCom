package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailPage;
import utils.InputData;

public class NewMailTest extends BaseTest{

    String emailSubject = "test subject";
    String emailBody = "some text to body";
    String recipient = "dashenka.anisimova.2000@gmail.com";

    @Test
    public void sendEmail(){
        User testUser = new User(InputData.LOGINNAME.getPersonalData(),InputData.PASSWORD.getPersonalData());
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = new MailPage(driver);
        loginPage.login(testUser);
        mailPage.sendEmail(recipient, emailSubject);
        int mailsCount = mailPage.checkSentMail();
        Assert.assertTrue(mailsCount>0, "The inbox folder is empty");

    }

}
