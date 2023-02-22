import io.restassured.response.ValidatableResponse;
import data.*;
import org.junit.*;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForTest {
    User user;
    String accessToken;
    WebDriver driver;
    UserClient userClient;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = CreateUsers.newUser();
        userClient = new UserClient();
        ValidatableResponse responseCreateUser = userClient.createUser(user);
        accessToken = responseCreateUser.extract().path("accessToken").toString().substring(7);
    }
    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}
