package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static url.URL.BASE_URL;

public class ForMain {
    private static final By profileButtonOnMainPage = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By buttonAccountOnMain = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By orderButtonOnMainPage = By.xpath(".//button[text()='Оформить заказ']");
    private static final By menu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private static final By buns = By.xpath(".//span[text()='Булки']");
    private static final By fillings = By.xpath(".//span[text()='Начинки']");
    private static final By sauces = By.xpath(".//span[text()='Соусы']");

    private final WebDriver driver;

    public ForMain(WebDriver driver) {
        this.driver = driver;
    }

    public ForMain openMainPage() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("клик по 'Войти в аккаунт' на главной странице, когда пользователь не авторизован")
    public ForLogin clickOnEnterInAccountOnMainButtonWhenUserNotLogin() {
        driver.findElement(buttonAccountOnMain).click();
        return new ForLogin(driver);
    }

    @Step("клик на 'личный кабинет', когда пользователь не авторизован")
    public ForLogin clickProfileButtonOnMainPageWhenUserNotLogin() {
        driver.findElement(profileButtonOnMainPage).click();
        return new ForLogin(driver);
    }

    @Step("клик на 'личный кабинет', когда пользователь авторизован")
    public ForProfile clickProfileButtonOnMainPageWhenUserLogin() {
        driver.findElement(profileButtonOnMainPage).click();
        return new ForProfile(driver);
    }
    @Step("присутствие кнопки 'оформить заказ'")
    public boolean orderButtonOnMainPage() {
        return driver.findElement(orderButtonOnMainPage).isDisplayed();
    }
    @Step("клик на раздел 'Булки'")
    public ForMain clickMenuBun() {
        driver.findElement(buns).click();
        return this;
    }
    @Step("клик на раздел 'Соусы'")
    public ForMain clickMenuSauce() {
        driver.findElement(sauces).click();
        return this;
    }
    @Step("клик на раздел 'Начинки'")
    public ForMain clickMenuFillings() {
        driver.findElement(fillings).click();
        return this;
    }
    @Step("берется текст из общего раздела меню для сравнения с выбранным разделом")
    public String getTextFromSelectedMenu() {
        return driver.findElement(menu).getText();
    }
}
