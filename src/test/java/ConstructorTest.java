import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.qameta.allure.junit4.DisplayName;
import java.time.Duration;
import org.junit.*;
import pom.*;

public class ConstructorTest {
    private WebDriver driver;
    private ForMain mainPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new ForMain(driver);
    }
    @Test
    @DisplayName("Проверка переход к разделу «Соусы»")
    public void menuSauceIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Проверка переход к разделу «Булки»")
    public void menuBunIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce()
                .clickMenuBun();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Проверка переход к разделу «Начинки»")
    public void menuFillingsIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuFillings();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }
    @After
    public void quit() {
        driver.quit();
    }
}
