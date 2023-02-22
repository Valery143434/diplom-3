package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static data.URL.FORGOT_PASSWORD;

public class ForPasswordOnRecoverPage {
    private static final By buttonEnterOnRecoverPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public ForPasswordOnRecoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForPasswordOnRecoverPage openRecoveryPage() {
        driver.get(FORGOT_PASSWORD);
        return this;
    }
    public ForLogin clickEnterButtonOnRecoveryPage() {
        driver.findElement(buttonEnterOnRecoverPage).click();
        return new ForLogin(driver);
    }
}
