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
        type(name, "login", By.id("login"));
        type(password, "password", By.id("password"));
        click("Entry", By.id("logBox_submit-button"));
        waitForVisibilityResult("link-logout", By.className("link-logout"));

    }

    public void loginFailure(String name, String password) {
        type(name, "login", By.id("login"));
        type(password, "password", By.id("password"));
        click("Entry", By.id("logBox_submit-button"));
        waitForVisibilityResult("logBox_recover", By.id("logBox_recover"));
//        not always be displayed
//        waitForVisibilityResult("logBox_form-alert", By.id("logBox_form-alert"));
    }
}
