package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AdsHandler {

    public static void removeAds(WebDriver driver) {

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Remove all iframe ads
            js.executeScript(
                    "document.querySelectorAll('iframe').forEach(e => e.remove());"
            );

        } catch (Exception e) {
            // ignore
        }
    }
}