package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test
    public void testPositiveLogin() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productPage.isPageOpened());

    }

    @Test
    public void testLoginWithoutUsername() {

        loginPage.open();
        loginPage.loginWithNegativeValue("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");


    }

    @Test
    public void testLoginWithoutPassword() {

        loginPage.open();
        loginPage.loginWithNegativeValue("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");

    }

    @Test
    public void loginSortAddtocartDel() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean tittleIsDisplayed = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();
        Assert.assertTrue(tittleIsDisplayed);
        driver.findElement(By.cssSelector("[Data-test=product-sort-container]")).click();
        driver.findElement(By.cssSelector("option[value='lohi']")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
    }

    @Test
    public void loginBuy() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean tittleIsDisplayed = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();
        Assert.assertTrue(tittleIsDisplayed);
        driver.findElement(By.cssSelector("[Data-test=product-sort-container]")).click();
        driver.findElement(By.cssSelector("option[value='lohi']")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("Test");
        driver.findElement(By.id("postal-code")).sendKeys("010101010101010");
        driver.findElement(By.id("continue")).click();
        String errorMessage = driver.findElement(By.cssSelector("[data-test=title]")).getText();
        Assert.assertEquals(errorMessage, "Checkout: Overview");
        driver.findElement(By.id("finish")).click();
        String errorMessage1 = driver.findElement(By.cssSelector("[data-test=title]")).getText();
        Assert.assertEquals(errorMessage1, "Checkout: Complete!");
        driver.findElement(By.id("back-to-products")).click();


    }
}
