package actions;


import blocks.MenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.SendQuestionPage;

public class GeneralActions {

    private WebDriver driver;
    private LoginPage loginPage;
    private SendQuestionPage sendQuestionPage;
    private MenuBlock menuBlock;
    private BasePage page;

    public GeneralActions(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        sendQuestionPage = new SendQuestionPage(driver);
        menuBlock = new MenuBlock(driver);
        page = new BasePage(driver);
    }

    public void login(String name, String password) {
        loginPage.open();
        loginPage.click("link-login", By.className("link-login"), "logBox", By.id("logBox"));
        loginPage.login(name, password);
    }
    public void loginFailure(String name, String password) {
        loginPage.open();
        loginPage.click("link-login", By.className("link-login"),"logBox", By.id("logBox"));
        loginPage.loginFailure(name, password);
    }


    public void logout() {
        menuBlock.logout();
        page.waitForVisibilityResult("link-login", By.className("link-login"));
    }

    public int getCountQuestions() {
        return menuBlock.getCountQuestions();
    }

    public void sendQuestion(String friendName, String question) {
        sendQuestionPage.openFriendForm(friendName);
        sendQuestionPage.type(question, "profile-input", By.id("profile-input"));
        sendQuestionPage.sendQuestion();
    }

}
