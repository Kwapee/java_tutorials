import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testConstructor() {
        Product product = new Product(1, "Dress", 36.0, 20);
        assertEquals(1, product.getId());
        assertEquals("Dress", product.getString());
        assertEquals(36.0, product.getPrice(), 20);
        assertEquals(20, product.getStockQuantity());
    }

    @Test
    public void testGetId() {
        Product product = new Product(2, "Milo", 20.0, 50);
        assertEquals(2, product.getId());
    }

    @Test
    public void testGetString() {
        Product product = new Product(3, "Air Force 1", 30.0, 80);
        assertEquals("Air Force 1", product.getString());
    }

    @Test
    public void testGetPrice() {
        Product product = new Product(4, "Product Price", 40.0, 40);
        assertEquals(40.0, product.getPrice(), 0.01);
    }

    @Test
    public void testGetStockQuantity() {
        Product product = new Product(5, "Product Stock", 50.0, 50);
        assertEquals(50, product.getStockQuantity());
    }

    @Test
    public void testSetStockQuantity() {
        Product product = new Product(6, "Product Update", 60.0, 60);
        product.setStockQuantity(70);
        assertEquals(70, product.getStockQuantity());
    }
    
}
