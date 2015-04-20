package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters({"browser", "URL"})
    @BeforeClass
    public void driverSetUp(String browser, String URL) {

        if (URL.equals("default")){
            if (browser.equals("chrome")) {
                driver.set(new ChromeDriver());
            }else if (browser.equals("firefox")) {
                driver.set(new FirefoxDriver());
            }
        }else {
            if (browser.equals("chrome")) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
                capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                try {
                    driver.set(new CustomRemoteWebDriver(new URL(URL), capabilities));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equals("firefox")) {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
                capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
                try {
                    driver.set(new CustomRemoteWebDriver(new URL(URL), capabilities));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @AfterClass
    public void driverTearDown() {
        driver.get().quit();
    }
}
