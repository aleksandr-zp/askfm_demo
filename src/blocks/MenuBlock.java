package blocks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reporter;

public class MenuBlock {
    public WebDriver driver;

    public MenuBlock(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        Reporter.log("Click Logout");
        driver.findElement(By.className("link-logout")).click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("link-login")));
    }

    public int getCountQuestions() {
        int countQuestions;
        Reporter.log("Get the number of questions");
        countQuestions = Integer.parseInt(driver.findElement(By.id("inbox_menu_counter")).getText().trim());
        return countQuestions;
    }

}
