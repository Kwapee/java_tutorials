import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderProcessingSystemTest {

    @Test
    public void testAddProduct() {
        Customer customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        Product product = new Product(1, "Dress", 36.0, 20);
        Order order = new Order(1, customer);

        try {
            order.addProduct(product, 10);
            assertEquals(1, order.getOrderItems().size());
            assertEquals(10, order.getOrderItems().get(0).getQuantity());
        } catch (OutOfStockException e) {
            fail("Should not throw OutOfStockException");
        }
    }

    @Test
    public void testAddProduct_OutOfStock() {
        Customer customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        Product product = new Product(1, "Dress", 36.0, 5);
        Order order = new Order(1, customer);

        try {
            order.addProduct(product, 10);
            fail("Should throw OutOfStockException");
        } catch (OutOfStockException e) {
            assertEquals("Product is out of stock", e.getMessage());
        }
    }

    @Test
    public void testUpdateProductQuantity() throws OutOfStockException {
        Customer customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        Product product = new Product(1, "Dress", 36.0, 20);
        Order order = new Order(1, customer);
        try {
            order.addProduct(product, 10);
        } catch (OutOfStockException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        order.updateProductQuantity(product, 15);
        assertEquals(15, order.getOrderItems().get(0).getQuantity());
    }

    public void updateProductQuantity(Product product, int quantity) throws OutOfStockException {
        int availableStock = product.getStockQuantity();
        if (quantity > availableStock) {
            throw new OutOfStockException("Not enough stock available for product " + product.getPrice());
        }
        // Update the quantity
    }

    @Test
    public void testRemoveProduct() {
        Customer customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        Product product = new Product(1, "Dress", 36.0, 20);
        Order order = new Order(1, customer);
        try {
            order.addProduct(product, 10);
        } catch (OutOfStockException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        order.removeProduct(product);
        assertEquals(0, order.getOrderItems().size());
    }

    @Test
    public void testCalculateTotalPrice() {
        Customer customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        Product product = new Product(1, "Dress", 36.0, 20);
        Order order = new Order(1, customer);
        try {
            order.addProduct(product, 10);
        } catch (OutOfStockException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertEquals(360.0, order.calculateTotalPrice(), 0.01);
    }
}