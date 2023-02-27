import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;
import java.time.Duration;
import static url.URL.*;

public class PageTransitionTest extends ForTest {
    @Test
    @DisplayName("переход в «Личный кабинет» по клику на «Личный кабинет»")
    public void goInProfileThroughProfileButtonTest() {
        ForMain mainPage = new ForMain(driver);
        mainPage.openMainPage();
        mainPage.clickOnEnterInAccountOnMainButtonWhenUserNotLogin();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE));
        Assert.assertEquals(LOGIN_PAGE, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void goFromProfileInConstructorTest() {
        ForMain mainPage = new ForMain(driver);
        mainPage.openMainPage().clickProfileButtonOnMainPageWhenUserNotLogin()
                .fillingLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton().clickProfileButtonOnMainPageWhenUserLogin().clickConstructorButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
    }
    @Test
    @DisplayName("переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void goFromProfileInConstructorThroughLogoTest() {
        ForMain mainPage = new ForMain(driver);
        mainPage.openMainPage().clickProfileButtonOnMainPageWhenUserNotLogin()
                .fillingLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton().clickProfileButtonOnMainPageWhenUserLogin().clickOnLogoButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(BASE_URL));
        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
    }
}
