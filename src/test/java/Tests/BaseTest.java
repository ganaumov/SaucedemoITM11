package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    InfoPage infoPage;
    OverviewPage overviewPage;
    CompletePage completePage;



    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        infoPage = new InfoPage(driver);
        overviewPage = new OverviewPage(driver);
        completePage = new CompletePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        driver.quit();
    }
}

