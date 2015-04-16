package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void logout(){

        Reporter.log("Click Logout");
        driver.findElement(By.className("link-logout")).click();
    }
}
