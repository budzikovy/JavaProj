import java.util.Scanner;

public class AdminPanel {

    private final ProductManager productManager;
    private final Scanner scanner;

    public AdminPanel(ProductManager productManager, Scanner scanner) {
        this.productManager = productManager;
        this.scanner = scanner;
    }

    public void start() {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Exit Admin Panel");
            System.out.print("Choose an option: ");

            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    adminRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct() {
        System.out.print("\nEnter Product Type (1. Computer, 2. Smartphone, 3. Electronics): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1:
                addComputer();
                break;
            case 2:
                addSmartphone();
                break;
            case 3:
                addElectronics();
                break;
            default:
                System.out.println("Invalid product type.");
        }
    }

    private void addComputer() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter Processor: ");
        String processor = scanner.nextLine();
        System.out.print("Enter RAM Size: ");
        int ramSize = scanner.nextInt();
        System.out.print("Enter Storage Size: ");
        int storageSize = scanner.nextInt();

        Computer computer = new Computer(productManager.getNextProductId(), name, price, quantity, processor, ramSize, storageSize);
        productManager.addProduct(computer);
        System.out.println("Computer added successfully.");
    }

    private void addSmartphone() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Battery Capacity: ");
        int batteryCapacity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Accessories: ");
        String accessories = scanner.nextLine();

        Smartphone smartphone = new Smartphone(productManager.getNextProductId(), name, price, quantity, color, batteryCapacity, accessories);
        productManager.addProduct(smartphone);
        System.out.println("Smartphone added successfully.");
    }

    private void addElectronics() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Electronics electronics = new Electronics(productManager.getNextProductId(), name, price, quantity);
        productManager.addProduct(electronics);
        System.out.println("Electronics added successfully.");
    }

    private void removeProduct() {
        System.out.print("\nEnter Product ID to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        boolean removed = productManager.removeProduct(productId);
        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void updateProduct() {
        System.out.print("\nEnter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = productManager.getProductById(productId);
        if (product != null) {
            System.out.println("Current Product Details: " + product);
            System.out.println("Enter New Details:");

            if (product instanceof Computer) {
                updateComputer((Computer) product);
            } else if (product instanceof Smartphone) {
                updateSmartphone((Smartphone) product);
            } else if (product instanceof Electronics) {
                updateElectronics((Electronics) product);
            } else {
                System.out.println("Invalid product type.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    private void updateComputer(Computer computer) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Processor: ");
        String processor = scanner.nextLine();
        System.out.print("Enter RAM Size: ");
        int ramSize = scanner.nextInt();
        System.out.print("Enter Storage Size: ");
        int storageSize = scanner.nextInt();

        computer.setName(name);
        computer.setPrice(price);
        computer.setAvailableQuant(quantity);
        computer.setProcessor(processor);
        computer.setRam(ramSize);
        computer.setStorage(storageSize);

        System.out.println("Computer updated successfully.");
    }

    private void updateSmartphone(Smartphone smartphone) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Battery Capacity: ");
        int batteryCapacity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Accessories: ");
        String accessories = scanner.nextLine();

        smartphone.setName(name);
        smartphone.setPrice(price);
        smartphone.setAvailableQuant(quantity);
        smartphone.setColor(color);
        smartphone.setBatteryCapacity(batteryCapacity);
        smartphone.setAccessories(accessories);

        System.out.println("Smartphone updated successfully.");
    }

    private void updateElectronics(Electronics electronics) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        electronics.setName(name);
        electronics.setPrice(price);
        electronics.setAvailableQuant(quantity);

        System.out.println("Electronics updated successfully.");
    }
}
