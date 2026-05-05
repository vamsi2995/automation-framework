package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;
import utils.TestContext;

public class LoginSteps {
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    LoginPage loginPage;

    @Given("User is on login page")
    public void user_on_login_page() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url") + "/login");
        logger.info("User navigated to login page");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void enter_valid_credentials() {

        String email = (TestContext.getEmail() != null)
                ? TestContext.getEmail()
                : ConfigReader.get("email");

        loginPage.enterEmail(email);
        loginPage.enterPassword(ConfigReader.get("password"));
        logger.info("Entered valid login credentials");
    }

    @When("Click login")
    public void click_login() {
        loginPage.clickLogin();
        logger.info("Clicked login button");

    }

    @When("User enters invalid credentials")
    public void enter_invalid_credentials() {

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("wrong_password"));
        logger.info("Entered invalid login credentials");
    }

    @Then("Error message should be displayed")
    public void validate_error_message() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
        logger.info("Error message displayed as expected");
    }

    @Then("User should login successfully")
    public void validate_login() {
        Assert.assertTrue(loginPage.isLoginSuccessful());
        logger.info("User login successful");
    }
}