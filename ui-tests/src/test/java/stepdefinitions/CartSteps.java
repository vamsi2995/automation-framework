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
import pages.ProductsPage;
import pages.CartPage;
import utils.AdsHandler;
import utils.ConfigReader;

public class CartSteps {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    private static final Logger logger = LogManager.getLogger(CartSteps.class);
    @Given("User is logged in")
    public void user_is_logged_in() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url") + "/login");
        logger.info("Navigating to login page");
        loginPage = new LoginPage(driver);

        loginPage.enterEmail(ConfigReader.get("email"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();
        logger.info("Logged in successfully");
    }

    @When("User navigates to products page")
    public void go_to_products() {

        productsPage = new ProductsPage(DriverFactory.getDriver());
        productsPage.goToProducts();
        logger.info("Navigated to product page");
    }

    @When("User adds product to cart")
    public void add_product() {

        productsPage.addFirstProductToCart();
        //DriverFactory.getDriver().get(ConfigReader.get("url") + "/view_cart");
        logger.info("Added the product to cart");
        productsPage.clickViewCart();
    }

    @Then("Product should be added to cart")
    public void validate_cart() {

        cartPage = new CartPage(DriverFactory.getDriver());
        Assert.assertTrue(cartPage.isProductDisplayed());
        logger.info("Product successfully verified in cart");
    }


    @Given("User is on cart page")
    public void user_on_cart_page() {

        WebDriver driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("url") + "/view_cart");

        cartPage = new CartPage(driver);
        logger.info("User is on cart page");
    }

    @When("User removes product")
    public void remove_product() {

        AdsHandler.removeAds(DriverFactory.getDriver());

        cartPage = new CartPage(DriverFactory.getDriver());
        cartPage.removeProduct();
        logger.info("Product removed from cart");
    }

    @Then("Cart should be empty")
    public void validate_empty_cart() {
        Assert.assertTrue(cartPage.isCartEmpty());
        logger.info("Cart is empty - validation successful");
    }
}