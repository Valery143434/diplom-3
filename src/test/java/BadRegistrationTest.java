import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.junit4.DisplayName;
import java.time.Duration;
import data.*;
import pom.*;
import static pom.ForRegistration.*;

public class BadRegistrationTest {
    private WebDriver driver;
    private User user;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = CreateUsers.newUser();
    }
    @Test
    @DisplayName("ошибка при неуспешная регистрация с некорректным паролем")
   public void badRegistrationTest() {
        ForRegistration registrationPage = new ForRegistration(driver);
        registrationPage.openRegisterPage()
                .enterName(user.getName())
                .enterEmail(user.getEmail())
                .enterPassword("0")
                .clickRegistrationButton();
        Assert.assertEquals("Ошибка не появилась", "Некорректный пароль",
                driver.findElement(badPasswordMassage).getText());
    }
    @After
    public void quit() {
        driver.quit();
    }
}
