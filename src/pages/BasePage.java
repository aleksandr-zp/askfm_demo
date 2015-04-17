package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Reporter;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibilityResult(String name, By locator){
        Reporter.log("Wait for " + name);
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click(String targetName, By targetLocator, String dstName, By dstLocator){
        Reporter.log("Click on : " + targetName);
        driver.findElement(targetLocator).click();
        waitForVisibilityResult(dstName, dstLocator);
    }
    public void click(String targetName, By targetLocator){
        Reporter.log("Click on : " + targetName);
        driver.findElement(targetLocator).click();
    }

    public void type(String text, String locatorName, By locator){
        Reporter.log(String.format("Type in textarea %s : %s",locatorName, text));
        WebElement inputLogin = driver.findElement(locator);
        inputLogin.sendKeys(text);
    }

}
