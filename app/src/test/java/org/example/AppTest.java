import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App operations = new App();

    @Test
    public void testCalculateDiscount() {
        assertEquals(90, operations.calculateDiscount(100, 10));
        assertThrows(IllegalArgumentException.class, () -> operations.calculateDiscount(0, 10));
    }

    @Test
    public void testApplyTax() {
        assertEquals(110, operations.applyTax(100, 10));
        assertThrows(IllegalArgumentException.class, () -> operations.applyTax(-10, 5));
    }

    @Test
    public void testProcessRefund() {
        assertEquals("Refund of $50.0 processed for Order ID: 123", operations.processRefund(123, 50));
        assertEquals("Invalid refund request", operations.processRefund(0, 100));
    }

    @Test
    public void testAddCustomer() {
        assertEquals("Customer added: John Doe", operations.addCustomer("John Doe", "john@example.com"));
        assertEquals("Invalid customer details", operations.addCustomer(null, null));
    }

    @Test
    public void testApplyPromoCode() {
        assertEquals(90, operations.applyPromoCode(100, "DISCOUNT10"));
        assertEquals(100, operations.applyPromoCode(100, "INVALIDCODE"));
    }

    // Test for SQL Injection Vulnerability in Generate Invoice
    @Test
    public void testGenerateInvoiceVulnerability() {
        // Simulating an order ID that could be used in a SQL injection attack
        String result = operations.generateInvoice(1, 100);
        assertEquals("Invoice generated for Order ID: 1 with total $100.0", result);
    }

    // Test for Insufficient Authorization in Apply Promo Code
    @Test
    public void testApplyPromoCodeVulnerability() {
        double result = operations.applyPromoCode(100, "DISCOUNT10");
        assertEquals(90, result); // Promo code applied without checking user authorization
    }

    // Test for Logging Sensitive Information
    @Test
    public void testLogSensitiveInfoVulnerability() {
        // Capturing console output would be needed here in real tests; simplified for now
        operations.logSensitiveInfo("admin", "password123");
    }

    // Test for Unsafe Admin Login
    @Test
    public void testAdminLoginVulnerability() {
        assertTrue(operations.adminLogin("admin", "password123"));  // Hardcoded credentials
        assertFalse(operations.adminLogin("admin", "wrongpassword"));
    }
}
