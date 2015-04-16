package tests;

import actions.GeneralActions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.StaticProvider;


public class SendQuestionTest extends BaseTest {
    private int questionsCountBefore;
    private int questionsCountAfter;
    private String questionText = "How are you?";
    private String xpathFriend = "//div[@class='people-name']/a[@href= '/qa3905test']";
    private GeneralActions generalActions;

    @BeforeClass()
    public void CountQuestionBefore() {
        generalActions = new GeneralActions(driver);

    }

    @Test(dataProvider = "loginQuestion1", dataProviderClass = StaticProvider.class)
    public void countQuestionsBeforeTest(String login1, String password1) {
        questionsCountBefore = generalActions.getCountQuestions(login1, password1);
    }

    @Test(dependsOnMethods = {"countQuestionsBeforeTest"}, dataProvider = "loginQuestion2", dataProviderClass = StaticProvider.class)
    public void sendMessageTest(String login2, String password2) {
        generalActions.sendQuestion(login2, password2, By.xpath(xpathFriend), questionText);

    }

    @Test(dependsOnMethods = {"sendMessageTest"}, dataProvider = "loginQuestion1", dataProviderClass = StaticProvider.class)
    public void receiveMessageTest(String login1, String password1) {
        questionsCountAfter = generalActions.getCountQuestions(login1, password1);
        Assert.assertTrue(questionsCountAfter > questionsCountBefore, String.format("Count questions before sending message is '%d' and after - is '%d' ", questionsCountBefore, questionsCountAfter));
    }
}
