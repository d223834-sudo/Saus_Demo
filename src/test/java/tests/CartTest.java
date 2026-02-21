package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Onesie";

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.checkTitleName(), "Products");

        productsPage.addGoodsToCart(goodsName);
        productsPage.switchToCart();

        assertEquals(cartPage.checkTitleName(), "Your Cart");
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
