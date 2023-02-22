package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import data.User;
import static data.URL.*;

public class ForRegistration {
    private final WebDriver driver;
    private static final By registerName = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By registerEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By registerPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By enterButtonOnRegistrationPage = By.xpath(".//*[text()='Войти']"); //кнопка "войти" на форме регистрации
    public static By badPasswordMassage = By.xpath(".//p[text()='Некорректный пароль']");

    public ForRegistration(WebDriver driver) {
        this.driver = driver;
    }
    public ForRegistration openRegisterPage() {
        driver.get(REGISTER_PAGE);
        return this;
    }
    public ForLogin clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return new ForLogin(driver);
    }
    public ForLogin clickRegistrationButtonOnRegistrationPage() {
        driver.findElement(enterButtonOnRegistrationPage).click();
        return new ForLogin(driver);
    }
    public ForRegistration registrationUser(User user) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(user.getName()); //ввести имя
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(user.getEmail()); //ввести e-mail
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(user.getPassword()); // ввести пароль
        return this;
    }
    public ForRegistration enterName(String name) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(name);
        return this;
    }
    public ForRegistration enterEmail(String email) {
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(email);
        return this;
    }
    public ForRegistration enterPassword(String password) {
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(password);
        return this;
    }
}