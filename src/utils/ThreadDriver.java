package utils;


import org.openqa.selenium.WebDriver;

public class ThreadDriver {
    private static WebDriver driver;

    private static final ThreadLocal<WebDriver> threadWebdriver =
            new ThreadLocal<WebDriver>() {
                @Override protected WebDriver initialValue() {
                    return driver;
                }
            };

    public static WebDriver getDriver() {
        return threadWebdriver.get();
    }
    public static void setDriver(WebDriver driver1){
        driver=driver1;
    }
}
