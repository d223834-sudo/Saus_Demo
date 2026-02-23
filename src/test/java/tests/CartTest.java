package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Onesie";

    @Test
    public void checkGoodsAdded() {
        System.out.println("CartTest.correct !!!!! in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.checkTitleName(), "Products");

        productsPage.addGoodsToCart(goodsName);
        productsPage.switchToCart();

        assertEquals(cartPage.checkTitleName(), "Your Cart");

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
