package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class SendQuestionPage {
    private WebDriver driver;

    public SendQuestionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLinkFriends(){
        Reporter.log("Click on link : main_menu_friends");
        driver.findElement(By.id("main_menu_friends")).click();
    }
    public void openFriendForm(By locator){
        Reporter.log("Click on link : \"link-name\"");
        driver.findElement(locator).click();
    }
    public void typeQuestion(String question){
        Reporter.log("Type question in text area");
        driver.findElement(By.id("profile-input")).sendKeys(question);
    }
    public void sendQuestion(){
        Reporter.log("Send  question");
        driver.findElement(By.id("question_submit")).click();
    }
}
