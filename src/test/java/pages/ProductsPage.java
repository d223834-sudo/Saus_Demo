package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By title = By.cssSelector("[data-test='title']");

    public ProductsPage(WebDriver driver) {
      super(driver);
    }

    public boolean isTitleIsDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
