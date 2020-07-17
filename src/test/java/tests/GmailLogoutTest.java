package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.InputData;

public class GmailLogoutTest extends BaseTest{

    @Test
    public void logOut() {
        User testUser = new User(InputData.LOGINNAME.getPersonalData(),InputData.PASSWORD.getPersonalData());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(testUser);
        String result = loginPage.logoutUser();
        Assert.assertEquals(result,"dashenka.anisimova.2000@gmail.com");

    }
}
