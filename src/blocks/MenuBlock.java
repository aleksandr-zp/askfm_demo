package blocks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Reporter;

public class MenuBlock {
    public WebDriver driver;

    public MenuBlock(WebDriver driver) {
        this.driver = driver;
    }
    public void logout(){
        Reporter.log("Click Logout");
        driver.findElement(By.className("link-logout")).click();
    }
    public int getCountQuestions(){
        int countQuestions;
        Reporter.log("Get the number of questions");
        countQuestions = Integer.parseInt(driver.findElement(By.id("inbox_menu_counter")).getText().trim());
        return countQuestions;
    }
}
