package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        Reporter.log("Open Ask.fm");
        driver.get("http://www.ask.fm/");
        waitForVisibilityResult("link-login", By.className("link-login"));
    }

    public void login(String name, String password) {
        Reporter.log("Login");
        type(name, "login", By.id("login"));
        type(password, "password", By.id("password"));
        click("logBox_submit-button", By.id("logBox_submit-button"));
        waitForVisibilityResult("link-logout", By.className("link-logout"));
    }

    public void loginFailure(String name, String password) {
        Reporter.log("Login");
        type(name, "login", By.id("login"));
        type(password, "password", By.id("password"));
        click("logBox_submit-button", By.id("logBox_submit-button"));
        //        Alert not always be displayed
        waitForVisibilityResult("logBox_recover", By.id("logBox_recover"));
    }
}
