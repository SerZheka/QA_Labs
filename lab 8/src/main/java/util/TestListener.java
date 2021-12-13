package util;


import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestFailure(ITestResult result) {
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    String.format(".//target/screenshots/%s.png", getCurrentTime())
            ));
        } catch (IOException e) {
            logger.error(String.format("Failed to save screenshot: %s", e.getMessage()));
        }
    }

    private String getCurrentTime() {
        return ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss"));
    }
}
