package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import create.User;
import static url.URL.*;

public class ForRegistration {
    private final WebDriver driver;
    private static final By registerName = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private static final By registerEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By registerPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private static final By registrationButtonOnRegistrationPage = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By enterButtonOnRegistrationPage = By.xpath(".//*[text()='Войти']");
    public static By badPasswordMassage = By.xpath(".//p[text()='Некорректный пароль']");

    public ForRegistration(WebDriver driver) {
        this.driver = driver;
    }
    @Step("открывается страница регистрации")
    public ForRegistration openRegisterPage() {
        driver.get(REGISTER_PAGE);
        return this;
    }
    @Step("клик по кнопке 'зарегистрироваться' на странице /register")
    public ForLogin clickRegistrationButtonOnRegistrationPage() {
        driver.findElement(registrationButtonOnRegistrationPage).click();
        return new ForLogin(driver);
    }
    @Step("клик по кнопке 'войти' на странице /register")
    public ForLogin clickEnterButtonOnRegistrationPage() {
        driver.findElement(enterButtonOnRegistrationPage).click();
        return new ForLogin(driver);
    }
    @Step("заполняется вся форма регистрации на странице /register")
    public ForRegistration sendDataInRegistrationFormOnRegistrationPage(User user) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(user.getName());
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(user.getEmail());
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(user.getPassword());
        return this;
    }

    @Step("заполняется только имя в форме регистрации на странице /register")
    public ForRegistration enterName(String name) {
        driver.findElement(registerName).click();
        driver.findElement(registerName).sendKeys(name);
        return this;
    }

    @Step("заполняется только e-mail в форме регистрации на странице /register")
    public ForRegistration enterEmail(String email) {
        driver.findElement(registerEmail).click();
        driver.findElement(registerEmail).sendKeys(email);
        return this;
    }

    @Step("заполняется только пароль в форме регистрации на странице /register")
    public ForRegistration enterPassword(String password) {
        driver.findElement(registerPassword).click();
        driver.findElement(registerPassword).sendKeys(password);
        return this;
    }
}