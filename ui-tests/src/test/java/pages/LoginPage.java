package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WaitUtils wait;

    //locators

    By email = By.xpath("//input[@data-qa='login-email']");
    By password = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By successText = By.xpath("//a[contains(text(),'Logged in as')]");

    //constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    //

    public void enterEmail(String mail) {
        wait.waitForElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        wait.waitForElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        wait.waitForElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        return wait.waitForElement(successText).isDisplayed();
    }

    By errorMsg = By.xpath("//p[contains(text(),'incorrect')]");

    public boolean isErrorDisplayed() {
        return wait.waitForElement(errorMsg).isDisplayed();
    }
}