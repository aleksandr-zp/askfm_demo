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

    public void clickSendQuestionButton() {
        Reporter.log("Send  question");
        click("question_submit", By.id("question_submit"));
        waitForVisibilityResult("text confirm that message was sent", By.id("reMotivation_box"));
    }

    public void typeQuestion(String question) {
        type(question, "profile-input", By.id("profile-input"));
    }
}
