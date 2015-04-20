package tests;


import actions.GeneralActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.StaticProvider;

public class LoginTest extends BaseTest {
    GeneralActions generalActions;

    @BeforeClass
    public void setUp() {
        generalActions = new GeneralActions(driver.get());
    }

    @Test(dataProvider = "person1", dataProviderClass = StaticProvider.class)
    public void loginTest(String login, String password) {
        generalActions.login(login, password);
        generalActions.logout();
    }

    @Test(dataProvider = "person2", dataProviderClass = StaticProvider.class)
    public void loginContainIncorrectNameTest(String login, String password) {
        generalActions.loginFailure(login, password);
    }

    @Test(dataProvider = "person3", dataProviderClass = StaticProvider.class)
    public void loginContainIncorrectPasswordTest(String login, String password) {
        generalActions.loginFailure(login, password);
    }
}
