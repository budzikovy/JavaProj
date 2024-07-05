import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public void addProductToCart(Product product, int quantity){
        if (cartItems.containsKey(product)){
            cartItems.put(product, cartItems.get(product) + quantity);
        } else {
            cartItems.put(product, quantity);
        }
    }

    public void viewCart(){
        if (cartItems.isEmpty()){
            System.out.println("\nCart is empty.");
        } else {
            System.out.println("\nCart contains: ");
            for (Map.Entry<Product, Integer> entry : cartItems.entrySet()){
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product + " | " + quantity);
            }
        }
    }

    public Map<Product, Integer> getCartItems(){
        return cartItems;
    }

}
