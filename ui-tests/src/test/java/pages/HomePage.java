package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By loginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}