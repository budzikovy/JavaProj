import java.util.Scanner;

public class Main {

    private static final ProductManager productManager = new ProductManager();

    public static void main(String[] args) {

//        ProductManager manager = new ProductManager();
//
//        Computer comp = new Computer(1, "Laptop", 1500.0, 10, "Intel i7", 16, 512);
//        Smartphone phone = new Smartphone(2, "Smartphone", 800.0, 20, "Black", 4000, "Earphones");
//        Electronics tv = new Electronics(3, "Television", 1200.0, 15);
//
//        manager.addProduct(comp);
//        manager.addProduct(phone);
//        manager.addProduct(tv);
//
//        System.out.println("All Products:");
//        manager.viewProducts()
//                .forEach(System.out::println);
//
//        System.out.println("\nUpdating Laptop Configuration:");
//        comp.configureSpecifications("Intel i9", 32, 1024);
//        manager.updateProduct(1, comp);
//        System.out.println(manager.getProductById(1));
//
//        System.out.println("\nCustomizing Smartphone:");
//        phone.configureSpecifications("Blue", 5000, "Charger, Earphones");
//        manager.updateProduct(2, phone);
//        System.out.println(manager.getProductById(2));
//
//        System.out.println("\nRemoving Television:");
//        manager.removeProduct(3);
//        manager.viewProducts()
//                .forEach(System.out::println);
//
//        System.out.println("\nAdding Products to Cart:");
//        manager.addProductToCart(1,2);
//        manager.addProductToCart(2,1);
//
//        System.out.println("\nViewing Cart:");
//        manager.viewCart();
//
//        System.out.println("\nPlacing Order:");
//        manager.placeOrder("John Doe", "john.doe@example.com");
//
////        System.out.println("\nViewing Orders:");
//        manager.viewOrders();

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
                        productManager.viewProducts();
                        break;
                    case 2:
                        addProductToCart(scanner);
                        break;
                    case 3:
                        productManager.viewCart();
                        break;
                    case 4:
                        placeOrder(scanner);
                        break;
                    case 5:
                        productManager.viewOrders();
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

    private static void addProductToCart(Scanner scanner) {
        System.out.print("\nEnter Product ID to add to cart: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        productManager.addProductToCart(productId, quantity);
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("\nEnter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();

        productManager.placeOrder(customerName, customerEmail);
    }

    }
