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
            String fileName = System.currentTimeMillis() + "_" + name + ".png";

            FileUtils.copyFile(src, new File("screenshots/" + fileName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}