package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private DriverSingleton(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            System.setProperty("webdriver.chrome.driver", "C://Users//Darya_Anisimava//Automation Mentoring Programm//webdriver//chrome83//chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
