package stepdefinitions;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.AdsHandler;
import utils.ConfigReader;
import utils.ScreenshotUtils;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.initDriver();
        WebDriver driver = DriverFactory.getDriver();

        driver.get(ConfigReader.get("url"));
        AdsHandler.removeAds(driver);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenshotUtils.capture(DriverFactory.getDriver(), scenario.getName());
        }

        DriverFactory.quitDriver();
    }
}
