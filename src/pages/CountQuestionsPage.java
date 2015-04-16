package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Reporter;

public class CountQuestionsPage {
    private WebDriver driver;

    public CountQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCountQuestions(){
        int countQuestions;
        Reporter.log("Get the number of questions");
        countQuestions = Integer.parseInt(driver.findElement(By.id("inbox_menu_counter")).getText().trim());
        return countQuestions;
    }
}
