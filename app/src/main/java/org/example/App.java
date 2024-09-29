import java.util.ArrayList;
import java.util.List;

public class App {

    // 1. Calculate Discount
    public double calculateDiscount(double totalAmount, double discountRate) {
        if (totalAmount <= 0 || discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("Invalid amount or discount rate");
        }
        return totalAmount * (1 - (discountRate / 100));
    }

    // 2. Apply Tax
    public double applyTax(double amount, double taxRate) {
        if (amount < 0 || taxRate < 0) {
            throw new IllegalArgumentException("Invalid tax rate or amount");
        }
        return amount + (amount * taxRate / 100);
    }

    // 3. Process Refund
    public String processRefund(int orderId, double refundAmount) {
        if (orderId <= 0 || refundAmount <= 0) {
            return "Invalid refund request";
        }
        return "Refund of $" + refundAmount + " processed for Order ID: " + orderId;
    }

    // 4. Add Customer
    public String addCustomer(String name, String email) {
        if (name == null || email == null) {
            return "Invalid customer details";
        }
        return "Customer added: " + name;
    }

    // 5. Generate Invoice
    public String generateInvoice(int orderId, double totalAmount) {
        if (orderId <= 0 || totalAmount <= 0) {
            return "Invalid invoice data";
        }
        return "Invoice generated for Order ID: " + orderId + " with total $" + totalAmount;
    }

    // 6. Check Stock
    public boolean checkStock(String productName, int quantity) {
        // Simulating a stock check
        return quantity > 0;
    }

    // 7. Track Shipment
    public String trackShipment(int trackingId) {
        if (trackingId <= 0) {
            return "Invalid tracking ID";
        }
        return "Tracking info for ID: " + trackingId;
    }

    // 8. Apply Promo Code
    public double applyPromoCode(double totalAmount, String promoCode) {
        if (promoCode.equals("DISCOUNT10")) {
            return totalAmount * 0.9;  // 10% discount
        }
        return totalAmount;
    }

    // 9. Add Items to Cart
    public List<String> addItemsToCart(List<String> cart, String item) {
        if (item != null && !item.isEmpty()) {
            cart.add(item);
        }
        return cart;
    }

    // 10. VULNERABLE: Unsafe Admin Login
    public boolean adminLogin(String username, String password) {
        // Security vulnerability: Hardcoded credentials and no encryption
        if (username.equals("admin") && password.equals("password123")) {
            return true;
        }
        return false;
    }
}
