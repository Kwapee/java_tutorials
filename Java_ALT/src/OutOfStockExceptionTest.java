import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OutOfStockExceptionTest {

    @Test
    public void testConstructor() {
        String message = "Not enough stock for product 'Dress'";
        OutOfStockException exception = new OutOfStockException(message);

        assertEquals(message, exception.getMessage());
    }

}