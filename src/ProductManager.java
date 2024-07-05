import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;
    private Cart cart;
    private OrderProcessing orderProcessing;
    private int nextProductId;

    public ProductManager() {
        products = new ArrayList<>();
        cart = new Cart();
        orderProcessing = new OrderProcessing();
        nextProductId = 1;
    }

    public int getNextProductId() {
        return nextProductId++;
    }

    public void addProduct(Product product) {
        product.setId(getNextProductId());
        products.add(product);
    }

    public boolean removeProduct(int productId) {
        return products.removeIf(product -> product.getId() == productId);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.set(i, updatedProduct);
                break;
            }
        }
    }

    public List<Product> viewProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void addProductToCart(int productId, int quantity) throws StoreExceptions.ProductOutOfStockException {
        Product product = getProductById(productId);
        if (product != null && quantity <= product.getAvailableQuant()) {
            cart.addProductToCart(product, quantity);
            product.setAvailableQuant(product.getAvailableQuant() - quantity);
            System.out.println("Product added to cart: " + product + " | " + quantity);
        } else {
            throw new StoreExceptions.ProductOutOfStockException("Product is out of stock or you provided a quantity larger than the product stock");
        }
    }

    public void viewCart() {
        cart.viewCart();
    }

    public void placeOrder(String customerName, String customerEmail) throws StoreExceptions.OrderProcessingException{
        if (cart.getCartItems().isEmpty()) {
            throw new StoreExceptions.OrderProcessingException("Cart is empty. Add something to cart");
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
