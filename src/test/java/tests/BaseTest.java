package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver = DriverSingleton.getDriver();

    }

    @AfterMethod
    public void tearDown(){

        DriverSingleton.closeDriver();

    }
}
