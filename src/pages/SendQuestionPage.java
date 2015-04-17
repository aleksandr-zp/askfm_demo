package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class SendQuestionPage extends BasePage {

    public SendQuestionPage(WebDriver driver) {
        super(driver);
    }


    public void openFriendForm(String friendName) {
        Reporter.log("Open friend's form");
        String URL = "http://ask.fm/" + friendName;
        driver.get(URL);
        waitForVisibilityResult("profile-input", By.id("profile-input"));
    }

    public void sendQuestion() {
        Reporter.log("Send  question");
        driver.findElement(By.id("question_submit")).click();
        waitForVisibilityResult("text confirm that message was sent", By.id("reMotivation_box"));
    }
}
