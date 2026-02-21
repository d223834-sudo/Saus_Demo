package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    By product = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsNames() {
        List <WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }
}
