package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static WebDriver driver;


    @BeforeClass
    public void driverSetUp() {

//        driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "D:\\Java_\\Java_EE\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterClass
    public void driverTearDown() {
        driver.quit();
    }
}
