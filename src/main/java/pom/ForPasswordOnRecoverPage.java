package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static url.URL.FORGOT_PASSWORD;

public class ForPasswordOnRecoverPage {
    private static final By buttonEnterOnRecoverPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public ForPasswordOnRecoverPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открывается страница /forgot-password")
    public ForPasswordOnRecoverPage openRecoveryPage() {
        driver.get(FORGOT_PASSWORD);
        return this;
    }
    @Step("клик по кнопке 'войти' на странице /forgot-password")
    public ForLogin clickEnterButtonOnRecoveryPage() {
        driver.findElement(buttonEnterOnRecoverPage).click();
        return new ForLogin(driver);
    }
}
