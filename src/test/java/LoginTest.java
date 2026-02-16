import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void firstLogin() {
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("user-name")).sendKeys(Keys.CONTROL + "A");

        browser.findElement(By.id("user-name")).sendKeys(Keys.BACK_SPACE);
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean titleIsDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        assertTrue(titleIsDisplayed, "Заголовок не виден");

        String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(titleName, "Products", "Неверный заголовок");
    }

    @Test
    public void incorrectLogin() {
        browser.findElement(By.id("user-name")).sendKeys("locked_out_user");
        browser.findElement(By.xpath("//*[@data-test='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[name='login-button']")).click();

        boolean errorIsDisplayed = browser.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
        assertTrue(errorIsDisplayed, "Нет сообщения об ошибке");

        String errorMsg = browser.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.",
                "Неверный текст сообщения об ошибке");
    }
}
