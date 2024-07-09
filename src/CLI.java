import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;

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
            scanner.nextLine();

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

        Product product = productManager.getProductById(productId);
        if (product instanceof Smartphone) {
            System.out.print("Do you want to configure the specifications? (yes/no): ");
            scanner.nextLine(); /
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                configureSmartphone((Smartphone) product);
            }
        } else if (product instanceof Computer) {
            System.out.print("Do you want to configure the specifications? (yes/no): ");
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                configureComputer((Computer) product);
            }
        }

        try {
            productManager.addProductToCart(productId, quantity);
            System.out.println("Product successfully added to cart.");
        } catch (StoreExceptions.ProductOutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void configureSmartphone(Smartphone smartphone) {
        SmartphoneSpecifications.Color color = chooseColor();
        SmartphoneSpecifications.BatteryCapacity batteryCapacity = chooseBattery();
        Set<SmartphoneSpecifications.Accessory> accessories = chooseAccessories();

        smartphone.configureSpecifications(color, batteryCapacity, accessories);
        System.out.println("Smartphone specifications configured successfully.");
    }

    private SmartphoneSpecifications.Color chooseColor() {
        System.out.println("Available Colors: ");
        SmartphoneSpecifications.Color[] colors = SmartphoneSpecifications.Color.values();
        for (int i = 0; i < colors.length; i++) {
            System.out.println((i + 1) + ". " + colors[i]);
        }
        System.out.print("Enter Color: ");
        int colorChoice = scanner.nextInt();
        scanner.nextLine();
        return colors[colorChoice - 1];
    }

    private SmartphoneSpecifications.BatteryCapacity chooseBattery() {
        System.out.println("Available Battery Capacities: ");
        SmartphoneSpecifications.BatteryCapacity[] batteries = SmartphoneSpecifications.BatteryCapacity.values();
        for (int i = 0; i < batteries.length; i++) {
            System.out.println((i + 1) + ". " + batteries[i]);
        }
        System.out.print("Enter Battery Capacity: ");
        int batteryChoice = scanner.nextInt();
        scanner.nextLine();
        return batteries[batteryChoice - 1];
    }

    private Set<SmartphoneSpecifications.Accessory> chooseAccessories() {
        System.out.println("Available Accessories: ");
        SmartphoneSpecifications.Accessory[] accessoriesArray = SmartphoneSpecifications.Accessory.values();
        for (int i = 0; i < accessoriesArray.length; i++) {
            System.out.println((i + 1) + ". " + accessoriesArray[i]);
        }
        System.out.print("Enter Accessory choices (comma separated): ");
        String accessoryChoices = scanner.nextLine();
        String[] choices = accessoryChoices.split(",");
        Set<SmartphoneSpecifications.Accessory> accessories = EnumSet.noneOf(SmartphoneSpecifications.Accessory.class);
        for (String choice : choices) {
            accessories.add(accessoriesArray[Integer.parseInt(choice.trim()) - 1]);
        }
        return accessories;
    }

    private void configureComputer(Computer computer) {
        ComputerSpecifications.Processor processor = chooseProcessor();
        ComputerSpecifications.RAM ram = chooseRAM();
        ComputerSpecifications.Storage storage = chooseStorage();

        computer.configureSpecifications(processor, ram, storage);
        System.out.println("Computer specifications configured successfully.");
    }

    private ComputerSpecifications.Processor chooseProcessor() {
        System.out.println("Available Processors: ");
        ComputerSpecifications.Processor[] processors = ComputerSpecifications.Processor.values();
        for (int i = 0; i < processors.length; i++) {
            System.out.println((i + 1) + ". " + processors[i]);
        }
        System.out.print("Enter Processor: ");
        int processorChoice = scanner.nextInt();
        scanner.nextLine();
        return processors[processorChoice - 1];
    }

    private ComputerSpecifications.RAM chooseRAM() {
        System.out.println("Available RAM Sizes: ");
        ComputerSpecifications.RAM[] rams = ComputerSpecifications.RAM.values();
        for (int i = 0; i < rams.length; i++) {
            System.out.println((i + 1) + ". " + rams[i].getSize() + "GB");
        }
        System.out.print("Enter RAM Size: ");
        int ramChoice = scanner.nextInt();
        scanner.nextLine();
        return rams[ramChoice - 1];
    }

    private ComputerSpecifications.Storage chooseStorage() {
        System.out.println("Available Storage Sizes: ");
        ComputerSpecifications.Storage[] storages = ComputerSpecifications.Storage.values();
        for (int i = 0; i < storages.length; i++) {
            System.out.println((i + 1) + ". " + storages[i].getSize() + "GB");
        }
        System.out.print("Enter Storage Size: ");
        int storageChoice = scanner.nextInt();
        scanner.nextLine();
        return storages[storageChoice - 1];
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
