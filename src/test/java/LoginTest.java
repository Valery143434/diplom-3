import pom.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends ForTest {
    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPageTest() {
        ForMain mainPage = new ForMain(driver);
        mainPage.openMainPage().clickOnEnterInAccountOnMainButtonWhenUserNotLogin()
                .fillingLoginForm(user.getEmail(), user.getPassword()).clickLoginButton();
        Assert.assertTrue(mainPage.orderButtonOnMainPage());
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginFromProfilePageTest() {
        ForMain mainPage = new ForMain(driver);
        mainPage.openMainPage().clickOnEnterInAccountOnMainButtonWhenUserNotLogin()
                .fillingLoginForm(user.getEmail(), user.getPassword()).clickLoginButton();
        Assert.assertTrue(mainPage.orderButtonOnMainPage());
    }
    @Test
    @DisplayName("вход через кнопку в форме регистрации,")
    public void loginFromRegistrationPageTest() {
        ForRegistration registrationPage = new ForRegistration(driver);
        registrationPage.openRegisterPage().clickEnterButtonOnRegistrationPage()
                .fillingLoginForm(user.getEmail(), user.getPassword()).clickLoginButton();
        ForMain mainPage = new ForMain(driver);
        Assert.assertTrue(mainPage.orderButtonOnMainPage());
    }
    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void loginFromRecoveryPageTest() {
        ForPasswordOnRecoverPage passwordRecoverPage = new ForPasswordOnRecoverPage(driver);
        passwordRecoverPage.openRecoveryPage().clickEnterButtonOnRecoveryPage()
                .fillingLoginForm(user.getEmail(), user.getPassword()).clickLoginButton();
        ForMain mainPage = new ForMain(driver);
        Assert.assertTrue(mainPage.orderButtonOnMainPage());
    }
}
