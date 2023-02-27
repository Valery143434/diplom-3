import io.restassured.response.ValidatableResponse;
import create.*;
import org.junit.*;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import requests.sendsRequests;

public class ForTest {
    protected User user;
    protected String accessToken;
    protected WebDriver driver;
    protected sendsRequests userClient;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = CreateUsers.newUser();
        userClient = new sendsRequests();
        ValidatableResponse responseCreateUser = userClient.createUserRequest(user);
        accessToken = responseCreateUser.extract().path("accessToken").toString().substring(7);
    }
    @After
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUserRequest(accessToken);
        }
        driver.quit();
    }
}
