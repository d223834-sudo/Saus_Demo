package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isTitleIsDisplayed();
        productsPage.addGoodsToCart("Sauce Labs Onesie");
        productsPage.addGoodsToCart("Sauce Labs Fleece Jacket");
        productsPage.addGoodsToCart("Test.allTheThings() T-Shirt (Red)");
        assertEquals(productsPage.checkCounterValue(), "3");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
