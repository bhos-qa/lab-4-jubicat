package org.example;

import java.util.HashMap;
import java.util.Map;

public class App {

    private Map<String, Integer> productStock = new HashMap<>();

    // Method 1: Add product to stock
    public void addProduct(String productName, int quantity) {
        productStock.put(productName, productStock.getOrDefault(productName, 0) + quantity);
    }

    // Method 2: Remove product from stock
    public void removeProduct(String productName, int quantity) {
        if (productStock.containsKey(productName) && productStock.get(productName) >= quantity) {
            productStock.put(productName, productStock.get(productName) - quantity);
        }
    }

    // Method 3: Get stock of a product
    public int getProductStock(String productName) {
        return productStock.getOrDefault(productName, 0);
    }

    // Method 4: Check if product is in stock
    public boolean isProductInStock(String productName) {
        return productStock.containsKey(productName) && productStock.get(productName) > 0;
    }

    // Method 5: Discount calculation (vulnerable method: no validation on discount percent)
    public double calculateDiscount(double price, double discountPercent) {
        return price - (price * (discountPercent / 100));
    }

    // Method 6: Calculate total price of products
    public double calculateTotalPrice(Map<String, Integer> products, double pricePerUnit) {
        int totalQuantity = products.values().stream().reduce(0, Integer::sum);
        return totalQuantity * pricePerUnit;
    }

    // Method 7: Calculate average price of products
    public double calculateAveragePrice(Map<String, Double> productPrices) {
        return productPrices.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    // Method 8: Restock product if below threshold
    public void restockProduct(String productName, int threshold, int restockAmount) {
        if (productStock.getOrDefault(productName, 0) < threshold) {
            productStock.put(productName, productStock.getOrDefault(productName, 0) + restockAmount);
        }
    }

    // Method 9: Clear all stock
    public void clearStock() {
        productStock.clear();
    }

    // Method 10: Check stock level and alert if too low
    public String checkStockLevel(String productName, int alertThreshold) {
        int stock = productStock.getOrDefault(productName, 0);
        return stock < alertThreshold ? "Alert: Stock is low!" : "Stock is sufficient";
    }

    // Vulnerable code (SQL Injection risk)
    public String vulnerableLogin(String username, String password) {
        // Directly concatenating input into SQL query (dangerous!)
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println("Executing query: " + query);
        // Simulate query execution
        return "Login query executed.";
    }
}