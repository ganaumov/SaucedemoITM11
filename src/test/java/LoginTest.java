import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void testPositiveLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean tittleIsDisplayed = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();
        Assert.assertTrue(tittleIsDisplayed);
    }

    @Test
    public void testLoginWithoutUsername() {
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
    }
    @Test
    public void testLoginWithoutPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector("[data-test=error]"));
        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
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
    @AfterMethod (alwaysRun = true)
    public void close() {
        driver.quit();
    }
}
