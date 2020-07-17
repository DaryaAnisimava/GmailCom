package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.InputData;

public class GmailLoginTest extends BaseTest{

    @Test
    public void loginUser() {
        User testUser = new User(InputData.LOGINNAME.getPersonalData(),InputData.PASSWORD.getPersonalData());
        Assert.assertTrue(new LoginPage(driver)
                .login(testUser)
                .getLoggedUserName().contains(testUser.getUsername()),"Wrong user login name!");
    }

}
