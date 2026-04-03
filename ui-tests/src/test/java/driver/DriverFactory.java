package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}