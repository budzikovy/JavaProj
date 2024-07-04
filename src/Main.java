import java.util.Scanner;

public class Main {

    private static final ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        // Initialize some products
        initializeProducts();

        // Start command line interface
        startCLI();
    }

    private static void initializeProducts() {
        Computer comp = new Computer(1, "Laptop", 1500.0, 10, "Intel i7", 16, 512);
        Smartphone phone = new Smartphone(2, "Smartphone", 800.0, 20, "Black", 4000, "Earphones");
        Electronics tv = new Electronics(3, "Television", 1200.0, 15);

        productManager.addProduct(comp);
        productManager.addProduct(phone);
        productManager.addProduct(tv);
    }

    private static void startCLI() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Online Store");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addProductToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder(scanner);
                    break;
                case 5:
                    viewOrders();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productManager.viewProducts()) {
            System.out.println(product);
        }
    }

    private static void addProductToCart(Scanner scanner) {
        System.out.print("\nEnter Product ID to add to cart: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        try {
            productManager.addProductToCart(productId, quantity);
            System.out.println("Product succesfully added to cart.");
        } catch (StoreExceptions.ProductOutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewCart() {
        System.out.println("\nCart Contents:");
        productManager.viewCart();
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("\nEnter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();

        try {
            productManager.placeOrder(customerName, customerEmail);
            System.out.println("Ordered successfully!");
        } catch (StoreExceptions.OrderProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewOrders() {
        productManager.viewOrders();
    }
}
