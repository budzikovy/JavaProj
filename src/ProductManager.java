import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;
    private Cart cart;
    private OrderProcessing orderProcessing;

    public ProductManager() {
        products = new ArrayList<>();
        cart = new Cart();
        orderProcessing = new OrderProcessing();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }

    public void viewProducts() {
        products.forEach(System.out::println);
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void addProductToCart(int productId, int quantity) {
        Product product = getProductById(productId);
        if (product != null && quantity <= product.getAvailableQuant()) {
            cart.addProductToCart(product, quantity);
            product.setAvailableQuant(product.getAvailableQuant() - quantity);
            System.out.println("Product added to cart: " + product + " | " + quantity);
        } else {
            System.out.println("Product not available or wrong quantity");
        }
    }

    public void viewCart() {
        cart.viewCart();
    }

    public void placeOrder(String customerName, String customerEmail) {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("The cart is empty. Add products to the cart before placing an order.");
        } else {
            orderProcessing.processOrder(customerName, customerEmail, cart.getCartItems());
            cart.getCartItems().clear();
        }
    }

    public void viewOrders() {
        System.out.println("\nViewing Orders:");
        for (Order order : orderProcessing.getOrders()) {
            System.out.println(order);
        }
    }

}
