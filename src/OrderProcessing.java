import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderProcessing {

    private List<Order> orders;
    private static int orderCounter = 1;

    public OrderProcessing() {
        orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    public static void setOrderCounter(int orderCounter) {
        OrderProcessing.orderCounter = orderCounter;
    }

    public void processOrder(String customerName, String customerEmail, Map<Product, Integer> cartItems) {
        Order order = new Order(orderCounter++, customerName, customerEmail, cartItems);
        orders.add(order);
        generateInvoice(order);
    }

    private void generateInvoice(Order order) {
        System.out.println("Invoice for Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Customer Email: " + order.getCustomerEmail());
        System.out.println("Ordered Products:");
        for (Map.Entry<Product, Integer> entry : order.getOrderedProducts().entrySet()) {
            System.out.println(entry.getKey().getName() + " - Quantity: " + entry.getValue() + " - Price: $" + entry.getKey().getPrice());
        }
        System.out.println("Total Amount: $" + order.getTotalAmount());
        System.out.println("Order Time: " + order.getOrderTime());
        System.out.println("=====================================");
    }



}
