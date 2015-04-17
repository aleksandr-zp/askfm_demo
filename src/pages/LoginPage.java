package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        Reporter.log("Open Ask.fm");
        driver.get("http://www.ask.fm/");
        waitForVisibilityResult("link-login", By.className("link-login"));
    }

    public void clickOpenLoginFormButton() {
        click("link-login", By.className("link-login"));
        waitForVisibilityResult("logBox", By.id("logBox"));
    }

    public void typeLoginName(String name) {
        type(name, "login", By.id("login"));
    }

    public void typeLoginPassword(String password) {
        type(password, "password", By.id("password"));
    }

    public void clickLoginButton() {
        click("logBox_submit-button", By.id("logBox_submit-button"));
    }

    public void waitForVisibilityResultLoginSuccess() {
        waitForVisibilityResult("link-logout", By.className("link-logout"));
    }

    public void waitForVisibilityResultLoginFailure() {
        waitForVisibilityResult("logBox_recover", By.id("logBox_recover"));
    }


}
