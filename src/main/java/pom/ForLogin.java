package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static data.URL.LOGIN_PAGE;

public class ForLogin {
    private static final By loginEnterButton = By.xpath(".//*[text()='Войти']");
    private static final By loginEmail = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private static final By loginPassword = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private final WebDriver driver;
    public ForLogin(WebDriver driver) {
        this.driver = driver;
    }
    public ForMain clickLoginButton() {
        driver.findElement(loginEnterButton).click();
        return new ForMain(driver);
    }
    public ForLogin fillingLoginForm(String email, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        driver.findElement(loginEmail).click();
        driver.findElement(loginEmail).sendKeys(email);
        driver.findElement(loginPassword).click();
        driver.findElement(loginPassword).sendKeys(password);
        return this;
    }
}
