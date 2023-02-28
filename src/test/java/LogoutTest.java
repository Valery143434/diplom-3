import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import java.time.Duration;
import static url.URL.LOGIN_PAGE;

public class LogoutTest extends ForTest {
    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        ForMain mainPage = new ForMain(driver);
        mainPage.openMainPage().clickOnEnterInAccountOnMainButtonWhenUserNotLogin()
                .fillingLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton().clickProfileButtonOnMainPageWhenUserLogin().clickLogoutButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        Assert.assertEquals(LOGIN_PAGE, driver.getCurrentUrl());
    }
}
