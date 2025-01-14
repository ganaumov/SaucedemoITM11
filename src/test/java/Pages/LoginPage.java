package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Открытие страницы Login Page")
    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step ("Вход в магазин с именем: {user} и паролем: {password}")
    public ProductPage login(String user, String password) {
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductPage(driver);
    }

    public void loginWithNegativeValue(String user, String password) {
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
