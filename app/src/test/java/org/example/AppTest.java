package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class AppTest {

    @Test
    public void testAddProduct() {
        App logic = new App();
        logic.addProduct("Apple", 10);
        assertEquals(10, logic.getProductStock("Apple"));
    }

    @Test
    public void testRemoveProduct() {
        App logic = new App();
        logic.addProduct("Orange", 20);
        logic.removeProduct("Orange", 5);
        assertEquals(15, logic.getProductStock("Orange"));
    }

    @Test
    public void testCalculateDiscount() {
        App logic = new App();
        double discountedPrice = logic.calculateDiscount(100, 20);
        assertEquals(80, discountedPrice);
    }

    @Test
    public void testIsProductInStock() {
        App logic = new App();
        logic.addProduct("Banana", 5);
        assertTrue(logic.isProductInStock("Banana"));
    }

    @Test
    public void testCalculateTotalPrice() {
        App logic = new App();
        Map<String, Integer> products = new HashMap<>();
        products.put("Item1", 2);
        products.put("Item2", 3);
        double totalPrice = logic.calculateTotalPrice(products, 50);
        assertEquals(250, totalPrice);
    }
}