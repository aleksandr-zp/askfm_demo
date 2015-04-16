package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Reporter;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        Reporter.log("Open Ask.fm");
        driver.get("http://www.ask.fm/");
    }

    public void clickLinkLogin(){
        Reporter.log("Click on link : \"link-login\"");
        driver.findElement(By.className("link-login")).click();
    }
    public void write(String text,String locatorName, By locator){
        Reporter.log("Write "+ locatorName);
        WebElement inputLogin = driver.findElement(locator);
        inputLogin.sendKeys(text);
    }
    public void login(String name, String password){
        write(name, "login", By.id("login"));
        write(password, "password", By.id("password"));
        Reporter.log("Click on button : \"Entry\"");
        driver.findElement(By.id("logBox_submit-button")).click();
    }
}
