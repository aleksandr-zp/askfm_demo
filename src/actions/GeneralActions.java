package actions;


import blocks.MenuBlock;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.SendQuestionPage;
import utils.Reporter;

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
        Reporter.log("Login");
        loginPage.openMainPage();
        loginPage.clickOpenLoginFormButton();
        loginPage.typeLoginName(name);
        loginPage.typeLoginPassword(password);
        loginPage.clickLoginButton();
        loginPage.waitForVisibilityResultLoginSuccess();
    }

    public void loginFailure(String name, String password) {
        Reporter.log("Login");
        loginPage.openMainPage();
        loginPage.clickOpenLoginFormButton();
        loginPage.typeLoginName(name);
        loginPage.typeLoginPassword(password);
        loginPage.clickLoginButton();
        loginPage.waitForVisibilityResultLoginFailure();
    }


    public void logout() {
        menuBlock.clickLogout();
    }

    public int getCountQuestions() {
        return menuBlock.getCountQuestions();
    }

    public void sendQuestion(String friendName, String question) {
        sendQuestionPage.openFriendForm(friendName);
        sendQuestionPage.typeQuestion(question);
        sendQuestionPage.clickSendQuestionButton();
    }

}
