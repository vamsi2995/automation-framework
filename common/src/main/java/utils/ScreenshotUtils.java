package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String name) {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("screenshots/" + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}