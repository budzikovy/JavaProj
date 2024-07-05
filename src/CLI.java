import java.util.Scanner;

public class CLI {

    private final ProductManager productManager;
    private final Scanner scanner;

    public CLI(ProductManager productManager) {
        this.productManager = productManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Online Store");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Admin Panel");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    viewOrders();
                    break;
                case 6:
                    startAdminPanel();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productManager.viewProducts()) {
            System.out.println(product);
        }
    }

    private void addProductToCart() {
        System.out.print("\nEnter Product ID to add to cart: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        try {
            productManager.addProductToCart(productId, quantity);
            System.out.println("Product successfully added to cart.");
        } catch (StoreExceptions.ProductOutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewCart() {
        System.out.println("\nCart Contents:");
        productManager.viewCart();
    }

    private void placeOrder() {
        System.out.print("\nEnter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();

        try {
            productManager.placeOrder(customerName, customerEmail);
            System.out.println("Order placed successfully!");
        } catch (StoreExceptions.OrderProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewOrders() {
        productManager.viewOrders();
    }

    private void startAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(productManager, scanner);
        adminPanel.start();
    }
}
