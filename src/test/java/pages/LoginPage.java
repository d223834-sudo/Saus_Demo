package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By loginInput = By.id("user-name");
    private final By loginButton = By.cssSelector("[name='login-button']");
    private final By passwordInput = By.cssSelector(DATA_TEST_PATTERN.formatted("password"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Логинимся под кредами пользователя")
    public void login(String user, String password) {
        fillLoginField(user);
        fillPasswordField(password);
        driver.findElement(loginButton).click();
    }

    public void login(User user) {
        fillLoginField(user.getEmail());
        fillPasswordField(user.getPassword());
        driver.findElement(loginButton).click();
    }

    @Step("Вводим логин {user}")
    public void fillLoginField(String user) {
        driver.findElement(loginInput).sendKeys(user);
    }

    @Step("Вводим пароль {password}")
    public void fillPasswordField(String password) {
       driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Проверяем видимость уведомления об ошибке")
    public boolean isErrorIsDisplayed() { return driver.findElement(errorMsg).isDisplayed(); }

    @Step("Проверяем текст ошибки")
    public String getErrorText() { return driver.findElement(errorMsg).getText(); }
}
