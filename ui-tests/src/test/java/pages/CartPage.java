package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class CartPage {

    WebDriver driver;
    WaitUtils wait;

    By cartProduct = By.xpath("//table[@id='cart_info_table']//tbody//tr");
    By deleteBtn = By.xpath("//a[@class='cart_quantity_delete']");
    By emptyMsg = By.xpath("//b[text()='Cart is empty!']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isProductDisplayed() {
        return wait.waitForElement(cartProduct).isDisplayed();
    }
    public void removeProduct() {

        WebElement delete = wait.waitForElement(deleteBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", delete);
    }

    public boolean isCartEmpty() {
        return wait.waitForElement(emptyMsg).isDisplayed();
    }
}


