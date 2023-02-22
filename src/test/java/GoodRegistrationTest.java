import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import data.*;
import pom.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import java.time.Duration;

public class GoodRegistrationTest {
    private WebDriver driver;
    private User user;
    private UserClient userClient;
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
        registrationPage.openRegisterPage().registrationUser(user).clickRegistrationButton()
                .fillingLoginForm(user.getEmail(), user.getPassword()).clickLoginButton();
        ForMain mainPage = new ForMain(driver);
        Assert.assertTrue(mainPage.mainPageOpen());
    }
    @After
    @DisplayName("удаляем пользователя и закрываем браузер")
    public void delete() {
        userClient = new UserClient();
        authorization = new Authorization(user.getEmail(), user.getPassword());
        ValidatableResponse responseLoginUser = userClient.loginUser(authorization);
        accessToken = responseLoginUser.extract().path("accessToken").toString().substring(7);
        userClient.deleteUser(accessToken);
        driver.quit();
    }

}
