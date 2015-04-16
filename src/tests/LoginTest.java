package tests;

//aleksandr_aleksandrov_ff -  123456abcdef;
// another_another - 123456abcdef;
// qa3905test - password! ;
// qa3906test - password! ;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Reporter;

public class LoginTest extends BaseTest {
    private String lgnRight1 = "qa3905test";
    private String pswdRight1 = "password!";
    private String lgnRight2 = "another_another";
    private String pswdRight2 = "123456abcdef";
    private String lgnWrong1 = "aleksandr_aleksandrov";
    private String pswdWrong1 = "123456abcdef123";

    @Test
    public void loginRightTest() {
        Reporter.log("Open Ask.fm");
        driver.get("http://www.ask.fm/");
        Reporter.log("Delete all cookies");
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reporter.log("ReOpen Ask.fm");
        driver.get("http://www.ask.fm/");
        Reporter.log("Wait for link : \"link-login\"");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-login")));
        Reporter.log("Click on link : \"link-login\"");
        driver.findElement(By.className("link-login")).click();

        Reporter.log("Write login");
        WebElement inputLogin = driver.findElement(By.id("login"));
        inputLogin.sendKeys(lgnRight1);
        Reporter.log("Write password");
        WebElement inputPassword = driver.findElement(By.id("password"));
        Reporter.log("Click on button : \"Entry\"");
        inputPassword.sendKeys(pswdRight1);
        driver.findElement(By.id("logBox_submit-button")).click();

        boolean isLogined = false;
        Reporter.log("Wait for link : \"link-logout\"");
        try {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-logout")));
//            WebElement element = driver.findElement(By.className("link-logout"));
            isLogined = true;
        } catch (TimeoutException e) {
            /*NOP*/
        } finally {
            Assert.assertTrue(isLogined, "Did not login in account");
        }
    }

    @Test
    public void loginWrongNameTest() {
        Reporter.log("Open Ask.fm");
        driver.get("http://www.ask.fm/");
        Reporter.log("Delete all cookies");
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reporter.log("ReOpen Ask.fm");
        driver.get("http://www.ask.fm/");
        Reporter.log("Wait for link : \"link-login\"");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-login")));
        Reporter.log("Click on link : \"link-login\"");
        driver.findElement(By.className("link-login")).click();

        Reporter.log("Write login");
        WebElement inputLogin = driver.findElement(By.id("login"));
        inputLogin.sendKeys(lgnWrong1);
        Reporter.log("Write password");
        WebElement inputPassword = driver.findElement(By.id("password"));
        Reporter.log("Click on button : \"Entry\"");
        inputPassword.sendKeys(pswdRight1);
        driver.findElement(By.id("logBox_submit-button")).click();

        boolean isLogined = false;
        Reporter.log("Wait for link : \"link-logout\"");
        try {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-logout")));
//            WebElement element = driver.findElement(By.className("link-logout"));
            isLogined = true;
        } catch (TimeoutException e) {
            /*NOP*/
        } finally {
            Assert.assertTrue(isLogined, "Did not login in account");
        }
    }
    @Test
    public void loginWrongPswdTest() {
        Reporter.log("Open Ask.fm");
        driver.get("http://www.ask.fm/");
        Reporter.log("Delete all cookies");
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Reporter.log("ReOpen Ask.fm");
        driver.get("http://www.ask.fm/");
        Reporter.log("Wait for link : \"link-login\"");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-login")));
        Reporter.log("Click on link : \"link-login\"");
        driver.findElement(By.className("link-login")).click();

        Reporter.log("Write login");
        WebElement inputLogin = driver.findElement(By.id("login"));
        inputLogin.sendKeys(lgnRight1);
        Reporter.log("Write password");
        WebElement inputPassword = driver.findElement(By.id("password"));
        Reporter.log("Click on button : \"Entry\"");
        inputPassword.sendKeys(pswdWrong1);
        driver.findElement(By.id("logBox_submit-button")).click();

        boolean isLogined = false;
        Reporter.log("Wait for link : \"link-logout\"");
        try {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-logout")));
//            WebElement element = driver.findElement(By.className("link-logout"));
            isLogined = true;
        } catch (TimeoutException e) {
            /*NOP*/
        } finally {
            Assert.assertTrue(isLogined, "Did not login in account");
        }
    }
}
