package stepdefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import pages.HomePage;
import pages.SignupPage;
import utils.ConfigReader;
import utils.TestContext;

public class SignupSteps {

    SignupPage signupPage;
    private static final Logger logger = LogManager.getLogger(SignupSteps.class);
    @Given("User is on signup page")
    public void user_on_signup_page() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url"));

        HomePage home = new HomePage(driver);
        home.clickLogin();
        logger.info("Navigated to signup page");
        signupPage = new SignupPage(driver);
    }

    @When("User enters signup details")
    public void enter_signup_details() {

        String email = "test" + System.currentTimeMillis() + "@gmail.com";

        TestContext.setEmail(email); 

        signupPage.enterName(ConfigReader.get("name"));
        signupPage.enterEmail(email);
        signupPage.clickSignup();
        logger.info("Entered signup details with dynamic email: {}", email);
    }

    @When("User fills account form")
    public void fill_account_form() {
        signupPage.fillForm();
        signupPage.clickCreateAccount();
        logger.info("Account form filled and submitted");
    }

    @Then("Account should be created successfully")
    public void validate_account() {
        Assert.assertTrue(signupPage.isAccountCreated());
        logger.info("Account created successfully and verified");
    }
}