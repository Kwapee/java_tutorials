import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class OrderTest {

    private Order order;
    private Customer customer;
    private Product product1;
    private Product product2;

    @Before
    public void setup() {
        customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        order = new Order(1, customer);
        product1 = new Product("Product 1", 10, 10);
        product2 = new Product("Product 2", 20, 20);
    }

    
    @Test
public void testAddProduct() {
    product1.setStockQuantity(10); 
    try {
        order.addProduct(product1, 2);
    } catch (OutOfStockException e) {
        fail("Product is out of stock");
    }
    List<OrderItem> orderItems = order.getOrderItems();
    assertEquals(1, orderItems.size());
    assertEquals(2, orderItems.get(0).getQuantity());
    assertEquals(0, order.calculateTotalPrice(), 0.01);
}

@Test
public void testRemoveProduct()  {
    try {
        order.addProduct(product1, 2);
    } catch (OutOfStockException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    order.removeProduct(product1);
    List<OrderItem> orderItems = order.getOrderItems();
    assertEquals(0, orderItems.size());
    assertEquals(0, order.calculateTotalPrice(), 0.01);
}


@Test
public void testUpdateProductQuantity() throws OutOfStockException {
    try {
        order.addProduct(product1, 2);
        List<OrderItem> orderItems = order.getOrderItems();
        assertEquals(1, orderItems.size()); 

        order.updateProductQuantity(product1, 3);
        orderItems = order.getOrderItems();
        assertEquals(1, orderItems.size()); 
        assertEquals(3, orderItems.get(0).getQuantity()); 
        assertEquals(30, order.calculateTotalPrice(), 0.01);
    } catch (OutOfStockException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    @Test(expected = OutOfStockException.class)
    public void testAddProductOutOfStock() throws OutOfStockException {
        order.addProduct(product1, 15);
    }

    @Test
    public void testSetTax() {
    }
}