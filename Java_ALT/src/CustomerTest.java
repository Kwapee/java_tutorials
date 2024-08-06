import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testConstructor() {
        Customer customer = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        assertEquals(1, customer.getId());
        assertEquals("Perry Amoako", customer.getName());
        assertEquals("perryamoako@gmail.com", customer.getEmail());
    }

    @Test
    public void testGetId() {
        Customer customer = new Customer(2, "Priscilla Agyapong", "priscillagyapong@gmail.com");
        assertEquals(2, customer.getId());
    }

    @Test
    public void testGetName() {
        Customer customer = new Customer(3, "Percy Amoako", "percyamoako@gmail.com");
        assertEquals("Percy Amoako", customer.getName());
    }


}