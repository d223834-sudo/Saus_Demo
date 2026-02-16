import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver browser;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //  options.addArguments("headless");
        browser = new ChromeDriver(options);
        browser.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closeBrowser() {
        browser.quit();
    }
}
