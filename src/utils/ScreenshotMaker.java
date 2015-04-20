package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class ScreenshotMaker extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        org.testng.Reporter.setCurrentTestResult(result);

        String imageName = result.getName() + "-" + System.currentTimeMillis() + ".png";
        String destFile = System.getProperty("report.dir") + File.separatorChar + "html"
                + File.separatorChar + imageName;

        try {
            File scrFile = ((TakesScreenshot) BaseTest.driver.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(destFile));
            Reporter.log("Screenshot saved:<br></br><a href = '" + imageName + "'><img src = '" + imageName + "' width='600'/></a>");
        } catch (Exception e) {
            Reporter.log("Error saving screenshot!");
        }
    }
}
