package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/signup.feature",
                "src/test/resources/features/login.feature",
                "src/test/resources/features/cart.feature"
        },
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}