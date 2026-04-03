package stepdefinitions;

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

    @Given("User is on signup page")
    public void user_on_signup_page() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url"));

        HomePage home = new HomePage(driver);
        home.clickLogin();

        signupPage = new SignupPage(driver);
    }

    @When("User enters signup details")
    public void enter_signup_details() {

        String email = "test" + System.currentTimeMillis() + "@gmail.com";

        TestContext.setEmail(email); 

        signupPage.enterName(ConfigReader.get("name"));
        signupPage.enterEmail(email);
        signupPage.clickSignup();
    }

    @When("User fills account form")
    public void fill_account_form() {
        signupPage.fillForm();
        signupPage.clickCreateAccount();
    }

    @Then("Account should be created successfully")
    public void validate_account() {
        Assert.assertTrue(signupPage.isAccountCreated());
    }
}