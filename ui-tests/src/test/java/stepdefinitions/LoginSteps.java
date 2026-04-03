package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    LoginPage loginPage;

    @Given("User is on login page")
    public void user_on_login_page() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url") + "/login");

        loginPage = new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void enter_valid_credentials() {

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));
    }

    @When("Click login")
    public void click_login() {
        loginPage.clickLogin();
    }

    @When("User enters invalid credentials")
    public void enter_invalid_credentials() {

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("wrong_password"));
    }

    @Then("Error message should be displayed")
    public void validate_error_message() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Then("User should login successfully")
    public void validate_login() {
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
}