package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import utils.ConfigReader;

public class SignupPage {

    WebDriver driver;
    WaitUtils wait;

    //locators

    By name = By.name("name");
    By email = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    By password = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address = By.id("address1");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobile = By.id("mobile_number");

    By createAccount = By.xpath("//button[@data-qa='create-account']");
    By successMsg = By.xpath("//b[text()='Account Created!']");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    //methods

    public void enterName(String userName) {
        wait.waitForElement(name).sendKeys(userName);
    }

    public void enterEmail(String userEmail) {
        wait.waitForElement(email).sendKeys(userEmail);
    }

    public void clickSignup() {
        wait.waitForElement(signupBtn).click();
    }

    public void fillForm() {

        wait.waitForElement(password).sendKeys(ConfigReader.get("password"));

        driver.findElement(firstName).sendKeys(ConfigReader.get("firstname"));
        driver.findElement(lastName).sendKeys(ConfigReader.get("lastname"));
        driver.findElement(address).sendKeys(ConfigReader.get("address"));
        driver.findElement(state).sendKeys(ConfigReader.get("state"));
        driver.findElement(city).sendKeys(ConfigReader.get("city"));
        driver.findElement(zipcode).sendKeys(ConfigReader.get("zipcode"));
        driver.findElement(mobile).sendKeys(ConfigReader.get("mobile"));
    }

    public void clickCreateAccount() {
        wait.waitForElement(createAccount).click();
    }

    public boolean isAccountCreated() {
        return wait.waitForElement(successMsg).isDisplayed();
    }
}