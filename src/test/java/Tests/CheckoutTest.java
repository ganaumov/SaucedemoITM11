package Tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    @Description("Выполнение е2е теста по покупке товара")
    @Severity(SeverityLevel.NORMAL)
    @Epic("SauceDemo")
    public void checkoutTest() throws InterruptedException {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Onesie")
                .clickToCart()
                .clickCheckout()
                .writeInfo("Vladimir", "Naumov", "107230")
                .clickContinue()
                .clickFinish();
        Assert.assertEquals(completePage.getMessage(), "Thank you for your order!");

    }
}

