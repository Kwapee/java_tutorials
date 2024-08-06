public class OrderProcessingSystem {

    public static void main(String[] args) throws OutOfStockException {
        Customer customer1 = new Customer(1, "Perry Amoako", "perryamoako@gmail.com");
        Customer customer2 = new Customer(2, "Priscilla Agyapong", "priscillaagyapong@gmail.com");
        Customer customer3 = new Customer(3,"Percy Amoako","percyamoako@gmail.com");

        Product product1 = new Product(1, "Dress", 36.0, 20);
        Product product2 = new Product(2, "Milo", 20.0, 50);
        Product product3 = new Product(3, "Air Force 1", 30.0, 80);

        Order order1 = new Order(1, customer1);
        Order order2 = new Order(2, customer2);
        Order order3 = new Order(3, customer3);
        
        try {
            order1.addProduct(product3, 5);
            order2.addProduct(product2, 10);
            order3.addProduct(product1, 20);
        } catch (OutOfStockException e) {
            e.printStackTrace();
        }

        //Update
        //order1.updateOrderItemQuantity(product3, 30);

        //Remove order item
        //order3.removeOrderItem(product1);

        //calculate
        System.out.println("Total Price for Order 1: " + order1.calculateTotalPrice());
        System.out.println("Total Price for Order 2: " + order2.calculateTotalPrice());
        System.out.println("Total Price for Order 3: " + order3.calculateTotalPrice());
        System.out.println("Total: " + (order1.calculateTotalPrice() + order2.calculateTotalPrice() + order3.calculateTotalPrice()));
    }
}