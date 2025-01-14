package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage {
    WebDriver driver;
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");

    public InfoPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение форм данных: {firstname}, {lastname}, {zipCode}")
    public InfoPage writeInfo(String firstName, String lastName, String zipCode){
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        return this;
    }

    @Step ("Переход на страницу {completePage}")
    public OverviewPage clickContinue(){
        driver.findElement(continueButton).click();
        return new OverviewPage(driver);
    }
}
