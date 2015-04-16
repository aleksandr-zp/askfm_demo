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
        generalActions = new GeneralActions(driver);
    }

    @Test(dataProvider = "login", dataProviderClass = StaticProvider.class)
    public void loginTest(String login, String password) {
        generalActions.login(login, password);
        generalActions.logout();
    }
}
