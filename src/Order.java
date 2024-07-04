import java.time.LocalDateTime;
import java.util.Map;

public class Order {

    private int orderId;
    private String customerName;
    private String customerEmail;
    private Map<Product, Integer> orderedProducts;
    private double totalAmount;
    private LocalDateTime orderTime;

    public Order(int orderId, String customerName, String customerEmail, Map<Product, Integer> orderedProducts) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderedProducts = orderedProducts;
        this.totalAmount = calculateTotalAmount();
        this.orderTime = LocalDateTime.now();
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Map<Product, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Map<Product, Integer> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.totalAmount = calculateTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    private double calculateTotalAmount() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : orderedProducts.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", orderedProducts=" + orderedProducts +
                ", totalAmount=" + totalAmount +
                ", orderTime=" + orderTime +
                '}';
    }
}
