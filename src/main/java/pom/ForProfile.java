package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForProfile {
    private static final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private static final By logoutButton = By.xpath(".//button[text()='Выход']");

    private final WebDriver driver;

    public ForProfile(WebDriver driver) {
        this.driver = driver;
    }

    @Step("клик по кнопке 'Конструктор'")
    public ForMain clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new ForMain(driver);
    }

    @Step("клик по логотипу 'Stellar Burgers'")
    public ForMain clickOnLogoButton() {
        driver.findElement(logoButton).click();
        return new ForMain(driver);
    }

    @Step("клик по кнопке 'выход'")
    public ForLogin clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new ForLogin(driver);
    }
}
