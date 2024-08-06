import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> orderItems;
    private double totalPrice;
    private double tax;
    private double discount;

    public Order(int id, Customer customer1) {
        this.id = id; // Corrected
        this.customer = customer1;
        this.orderItems = new ArrayList<>();
        this.discount = 0.0;
        this.tax = 0.00;
    }

    public void addProduct(Product product2, int quantity) throws OutOfStockException {
        if (product2.getStockQuantity() < quantity) {
            throw new OutOfStockException("Product is out of stock");
        }
        OrderItem orderItem = new OrderItem(product2, quantity, null);
        orderItems.add(orderItem);
        updateTotalPrice();
    }

    public void removeOrderItem(Product product) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().equals(product)) {
                orderItems.remove(orderItem);
                updateTotalPrice();
                return;
            }
        }
    }


    public void updateOrderItemQuantity(Product product, int newQuantity) {
        OrderItem orderItem = getOrderItem(product);
        if (orderItem != null) {
            if (product.getStockQuantity() >= newQuantity) {
                orderItem.setQuantity(newQuantity);
                updateTotalPrice();
            } else {
                throw new RuntimeException("Out of stock");
            }
        }
    }


    void updateTotalPrice() {
        totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getSubtotal();
        }
        totalPrice += totalPrice * tax;
        totalPrice -= totalPrice * discount;
    }

    public double calculateTotalPrice() {
        return totalPrice;
    }

    public void setTax(double tax) {
        this.tax = tax;
        updateTotalPrice();
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        updateTotalPrice();
    }


    public Double getTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotal'");
    }

    public OrderItem getOrderItem(Product product) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct().equals(product)) {
                return orderItem;
            }
        }
        return null; // or throw an exception if not found
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void removeProduct(Product product) {
        OrderItem orderItem = getOrderItem(product);
        if (orderItem != null) {
            orderItems.remove(orderItem);
            updateTotalPrice();
        }
    }

    public void updateProductQuantity(Product product, int i) {
        OrderItem orderItem = getOrderItem(product);
        if (orderItem != null) {
            orderItem.setQuantity(i);
            updateTotalPrice();
        }
    }
   


}
    


