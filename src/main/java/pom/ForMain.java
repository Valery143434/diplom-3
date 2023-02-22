package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static data.URL.BASE_URL;

public class ForMain {
    private static final By profileButton = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By buttonAccountOnMain = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By orderButton = By.xpath(".//button[text()='Оформить заказ']");

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

    public ForLogin clickAccountButton() {
        driver.findElement(buttonAccountOnMain).click();
        return new ForLogin(driver);
    }

    public ForLogin clickProfile() {
        driver.findElement(profileButton).click();
        return new ForLogin(driver);
    }

    public ForProfile clickProfileWhenUserLogin() {
        driver.findElement(profileButton).click();
        return new ForProfile(driver);
    }
    public boolean mainPageOpen() {
        return driver.findElement(orderButton).isDisplayed();
    }
    public ForMain clickMenuBun() {
        driver.findElement(buns).click();
        return this;
    }
    public ForMain clickMenuSauce() {
        driver.findElement(sauces).click();
        return this;
    }
    public ForMain clickMenuFillings() {
        driver.findElement(fillings).click();
        return this;
    }
    public String getTextFromSelectedMenu() {
        return driver.findElement(menu).getText();
    }
}
