public class OrderItem {

    private Product product;
    private int quantity;
    private Order order;

    public OrderItem(Product product, int quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    public  Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public void setQuantity(int quantity) {
       this.quantity = quantity; 
    }

    public void remove(OrderItem orderItem) {
        order.removeProduct(product);
    }
}