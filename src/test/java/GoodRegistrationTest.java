import login.Authorization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import create.*;
import pom.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import requests.sendsRequests;

import java.time.Duration;

public class GoodRegistrationTest {
    private WebDriver driver;
    private User user;
    private sendsRequests userClient;
    private String accessToken;
    private Authorization authorization;
    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = CreateUsers.newUser();
    }
    @Test
    @DisplayName("успешная регистрация")
    public void goodRegistrationTest() {
        ForRegistration registrationPage = new ForRegistration(driver);
        registrationPage.openRegisterPage().sendDataInRegistrationFormOnRegistrationPage(user).clickRegistrationButtonOnRegistrationPage()
                .fillingLoginForm(user.getEmail(), user.getPassword()).clickLoginButton();
        ForMain mainPage = new ForMain(driver);
        Assert.assertTrue(mainPage.orderButtonOnMainPage());
    }
    @After
    @DisplayName("удаляем пользователя и закрываем браузер")
    public void delete() {
        userClient = new sendsRequests();
        authorization = new Authorization(user.getEmail(), user.getPassword());
        ValidatableResponse responseLoginUser = userClient.loginUserRequest(authorization);
        accessToken = responseLoginUser.extract().path("accessToken").toString().substring(7);
        userClient.deleteUserRequest(accessToken);
        driver.quit();
    }

}
