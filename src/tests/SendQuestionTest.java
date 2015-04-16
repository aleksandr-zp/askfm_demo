package tests;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Reporter;

/**
 * Created by Александр on 15.04.2015.
 * <div id="notification-q-digit">1</div>
 * //div[@class='people-name']/a[@href= '/qa3905test']
 */

//aleksandr_aleksandrov_ff -  123456abcdef;
// another_another - 123456abcdef;
// qa3905test - password! ;
// qa3906test - password! ;

public class SendQuestionTest extends BaseTest {
    public Integer questionsCountBefore;
    public Integer questionsCountAfter;
    private String lgnRight1 = "qa3905test";
    private String pswdRight1 = "password!";
    private String lgnRight2 = "qa3906test";
    private String pswdRight2 = "123456abcdef";
    private String xpathFriend = "//div[@class='people-name']/a[@href= '/qa3905test']";

    @BeforeClass
    public void CountQuestionBefore() {
        driver.get("http://www.ask.fm/");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-login")));
        driver.findElement(By.className("link-login")).click();

        WebElement inputLogin = driver.findElement(By.id("login"));
        inputLogin.sendKeys(lgnRight1);
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(pswdRight1);
        driver.findElement(By.id("logBox_submit-button")).click();

        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("main_menu_inbox")));
        questionsCountBefore = Integer.parseInt(driver.findElement(By.id("inbox_menu_counter")).getText().trim());
        driver.findElement(By.className("link-logout")).click();
    }

    @Test
    public void sendMessageTest() {
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
        inputLogin.sendKeys(lgnRight2);
        Reporter.log("Write password");
        WebElement inputPassword = driver.findElement(By.id("password"));
        Reporter.log("Click on button : \"Entry\"");
        inputPassword.sendKeys(pswdRight1);
        driver.findElement(By.id("logBox_submit-button")).click();

        Reporter.log("Wait for link : \"Friends\" be active");
        WebElement friendsBtn = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("main_menu_friends")));
        friendsBtn.click();

        Reporter.log("Wait for link : \"link-name\"");
        WebElement friendsNameRef = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFriend)));
        Reporter.log("Click on link : \"link-name\"");
        friendsNameRef.click();

        Reporter.log("Write question in text area");
        WebElement questionTextArea = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-input")));
        questionTextArea.sendKeys("How are you?");

        Reporter.log("Send  question");
        driver.findElement(By.id("question_submit")).click();

        Reporter.log("Wait for text confirm that message was sent");
        WebElement confirmTextElem = new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reMotivation_box']/h1")));
        String confirmText = confirmTextElem.getText().trim();
        System.out.println(confirmText);
        Assert.assertTrue( StringUtils.containsIgnoreCase("Your question has been sent.", confirmText), String.format("String 'Your question has been sent.' is not contains actual result '%s' ", confirmText) );

        Reporter.log("Click Logout");
        driver.findElement(By.className("link-logout")).click();


    }
    @Test(dependsOnMethods = {"sendMessageTest"})
    public void recieveMessageTest(){
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

        WebElement inputLogin = driver.findElement(By.id("login"));
        inputLogin.sendKeys(lgnRight1);
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(pswdRight1);
        driver.findElement(By.id("logBox_submit-button")).click();

        Reporter.log("Wait for link : \"Inbox\" be active");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("main_menu_inbox")));

        Reporter.log("Compare the number of messages before and after sending");
        questionsCountAfter = Integer.parseInt(driver.findElement(By.id("inbox_menu_counter")).getText().trim());

        Assert.assertTrue(questionsCountAfter > questionsCountBefore, String.format("Count questions before sending message is '%d' and after - is '%d' ", questionsCountBefore, questionsCountAfter));
    }
}
