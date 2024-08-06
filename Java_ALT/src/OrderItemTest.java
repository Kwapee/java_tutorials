import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void testConstructor() {
        Product product = new Product("Test Product", 0, 10.0);
        OrderItem orderItem = new OrderItem(product, 2, null);
        assertEquals(product, orderItem.getProduct());
        assertEquals(2, orderItem.getQuantity());
    }

    @Test
    public void testGetSubtotal() {
        Product product = new Product("Test Product", 0, 10.0);
        OrderItem orderItem = new OrderItem(product, 2, null);
        assertEquals(0.0, orderItem.getSubtotal(), 0.01);
    }

    @Test
    public void testSetQuantity() {
        Product product = new Product("Test Product", 0, 10.0);
        OrderItem orderItem = new OrderItem(product, 2, null);
        orderItem.setQuantity(3);
        assertEquals(3, orderItem.getQuantity());
    }

    @Test
    public void testRemove() {
        Product product = new Product("Test Product", 0, 10.0);
        Order order = new Order(1, new Customer(1, "Test Customer", "test@example.com"));
        OrderItem orderItem = new OrderItem(product, 2, order);
        orderItem.remove(orderItem);
    }
}