import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    Apps operations = new App();

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
}
