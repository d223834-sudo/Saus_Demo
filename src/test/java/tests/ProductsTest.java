package tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {
    List<String> goodsList = new ArrayList<>(
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie", "Sauce Labs Fleece Jacket")
    );

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitleIsDisplayed());
        assertEquals(productsPage.checkTitleName(), "Products");
        for (int i = 0; i < goodsList.size(); i++) {
            productsPage.addGoodsToCart(goodsList.get(i));
        }

        productsPage.addGoodsToCart(2);

        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
