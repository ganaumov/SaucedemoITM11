package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход на страницу {checkout}")
    public InfoPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new InfoPage(driver);
    }
}