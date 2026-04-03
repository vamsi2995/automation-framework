

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.AdsHandler;
import utils.WaitUtils;

public class ProductsPage {

    WebDriver driver;
    WaitUtils wait;

    By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    By firstProduct = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    By addToCart = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By viewCart = By.xpath("//u[text()='View Cart']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public void goToProducts() {
        wait.waitForElement(productsBtn).click();
    }

    public void addFirstProductToCart() {

        AdsHandler.removeAds(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(wait.waitForElement(firstProduct)).perform();

        AdsHandler.removeAds(driver);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",
                        wait.waitForElement(addToCart));
    }

    public void clickViewCart() {
        wait.waitForElement(viewCart).click();
    }
}
