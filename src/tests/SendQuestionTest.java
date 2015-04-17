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
    private String friendName = "qa3905test";
    private GeneralActions generalActions;

    @BeforeClass()
    public void CountQuestionBefore() {
        generalActions = new GeneralActions(driver);

    }

    @Test(dataProvider = "personQuestions1", dataProviderClass = StaticProvider.class)
    public void countQuestionsBeforeTest(String login1, String password1) {
        generalActions.login(login1, password1);
        questionsCountBefore = generalActions.getCountQuestions();
        generalActions.logout();
    }

    @Test(dependsOnMethods = {"countQuestionsBeforeTest"}, dataProvider = "personQuestions2", dataProviderClass = StaticProvider.class)
    public void sendMessageTest(String login2, String password2) {
        generalActions.login(login2, password2);
        generalActions.sendQuestion(friendName, questionText);
        generalActions.logout();

    }

    @Test(dependsOnMethods = {"sendMessageTest"}, dataProvider = "personQuestions1", dataProviderClass = StaticProvider.class)
    public void receiveMessageTest(String login1, String password1) {
        generalActions.login(login1, password1);
        questionsCountAfter = generalActions.getCountQuestions();
        generalActions.logout();
        Assert.assertTrue(questionsCountAfter > questionsCountBefore, String.format("Count questions before sending message is '%d' and after - is '%d' ", questionsCountBefore, questionsCountAfter));
    }
}
