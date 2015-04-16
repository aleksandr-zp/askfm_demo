package actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CountQuestionsPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SendQuestionPage;
import utils.Reporter;

public class GeneralActions {

    private WebDriver driver;
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private CountQuestionsPage countQuestionsPage;
    private SendQuestionPage sendQuestionPage;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        countQuestionsPage = new CountQuestionsPage(driver);
        sendQuestionPage = new SendQuestionPage(driver);

    }

    public void waitForVisabilityResult(String name, By locator) {
        Reporter.log("Wait for " + name);
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void login(String name, String password) {
        loginPage.open();
        waitForVisabilityResult("link-login", By.className("link-login"));
        loginPage.clickLinkLogin();
        waitForVisabilityResult("logBox", By.id("logBox"));
        loginPage.login(name, password);
        waitForVisabilityResult("link-logout", By.className("link-logout"));

    }

    public void logout() {
        logoutPage.logout();
        waitForVisabilityResult("link-login", By.className("link-login"));
    }

    public int getCountQuestions(String name, String password) {
        int countQuestions;
        login(name, password);
        countQuestions = countQuestionsPage.getCountQuestions();
        logout();
        return countQuestions;
    }

    public void sendQuestion(String name, String password, By friendLocator, String question) {
        login(name, password);
        sendQuestionPage.openLinkFriends();
        waitForVisabilityResult("link-name", friendLocator);
        sendQuestionPage.openFriendForm(friendLocator);
        waitForVisabilityResult("profile-input", By.id("profile-input"));
        sendQuestionPage.typeQuestion(question);
        sendQuestionPage.sendQuestion();
        waitForVisabilityResult("text confirm that message was sent", By.xpath("//*[@id='reMotivation_box']/h1"));
        logout();
    }

}
