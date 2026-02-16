import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstLoginTest {

    @Test
    public void firstLogin() {
        //открыть браузер
        //зайти на сайт https://www.saucedemo.com/

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");



        // browser.quit();

    }
}