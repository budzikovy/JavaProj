import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;

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
        scanner.nextLine();

        ComputerSpecifications.Processor processor = chooseProcessor();
        ComputerSpecifications.RAM ramSize = chooseRAM();
        ComputerSpecifications.Storage storageSize = chooseStorage();

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

        SmartphoneSpecifications.Color color = chooseColor();
        SmartphoneSpecifications.BatteryCapacity batteryCapacity = chooseBattery();
        Set<SmartphoneSpecifications.Accessory> accessories = chooseAccessories();

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

        ComputerSpecifications.Processor processor = chooseProcessor();
        ComputerSpecifications.RAM ramSize = chooseRAM();
        ComputerSpecifications.Storage storageSize = chooseStorage();

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

        SmartphoneSpecifications.Color color = chooseColor();
        SmartphoneSpecifications.BatteryCapacity batteryCapacity = chooseBattery();
        Set<SmartphoneSpecifications.Accessory> accessories = chooseAccessories();

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

    private ComputerSpecifications.Processor chooseProcessor() {
        System.out.println("Available Processors: ");
        for (int i = 0; i < ComputerSpecifications.Processor.values().length; i++) {
            System.out.println((i + 1) + ". " + ComputerSpecifications.Processor.values()[i]);
        }
        System.out.print("Enter Processor: ");
        int processorChoice = scanner.nextInt();
        scanner.nextLine();
        return ComputerSpecifications.Processor.values()[processorChoice - 1];
    }

    private ComputerSpecifications.RAM chooseRAM() {
        System.out.println("Available RAM Sizes: ");
        for (int i = 0; i < ComputerSpecifications.RAM.values().length; i++) {
            System.out.println((i + 1) + ". " + ComputerSpecifications.RAM.values()[i]);
        }
        System.out.print("Enter RAM Size: ");
        int ramChoice = scanner.nextInt();
        scanner.nextLine();
        return ComputerSpecifications.RAM.values()[ramChoice - 1];
    }

    private ComputerSpecifications.Storage chooseStorage() {
        System.out.println("Available Storage Sizes: ");
        for (int i = 0; i < ComputerSpecifications.Storage.values().length; i++) {
            System.out.println((i + 1) + ". " + ComputerSpecifications.Storage.values()[i]);
        }
        System.out.print("Enter Storage Size: ");
        int storageChoice = scanner.nextInt();
        scanner.nextLine();
        return ComputerSpecifications.Storage.values()[storageChoice - 1];
    }

    private SmartphoneSpecifications.Color chooseColor() {
        System.out.println("Available Colors: ");
        for (int i = 0; i < SmartphoneSpecifications.Color.values().length; i++) {
            System.out.println((i + 1) + ". " + SmartphoneSpecifications.Color.values()[i]);
        }
        System.out.print("Enter Color: ");
        int colorChoice = scanner.nextInt();
        scanner.nextLine();
        return SmartphoneSpecifications.Color.values()[colorChoice - 1];
    }

    private SmartphoneSpecifications.BatteryCapacity chooseBattery() {
        System.out.println("Available Battery Capacities: ");
        for (int i = 0; i < SmartphoneSpecifications.BatteryCapacity.values().length; i++) {
            System.out.println((i + 1) + ". " + SmartphoneSpecifications.BatteryCapacity.values()[i]);
        }
        System.out.print("Enter Battery Capacity: ");
        int batteryChoice = scanner.nextInt();
        scanner.nextLine();
        return SmartphoneSpecifications.BatteryCapacity.values()[batteryChoice - 1];
    }

    private Set<SmartphoneSpecifications.Accessory> chooseAccessories() {
        System.out.println("Available Accessories: ");
        for (int i = 0; i < SmartphoneSpecifications.Accessory.values().length; i++) {
            System.out.println((i + 1) + ". " + SmartphoneSpecifications.Accessory.values()[i]);
        }
        System.out.print("Enter Accessory choices (comma separated): ");
        String accessoryChoices = scanner.nextLine();
        String[] choices = accessoryChoices.split(",");
        Set<SmartphoneSpecifications.Accessory> accessories = EnumSet.noneOf(SmartphoneSpecifications.Accessory.class);
        for (String choice : choices) {
            accessories.add(SmartphoneSpecifications.Accessory.values()[Integer.parseInt(choice.trim()) - 1]);
        }
        return accessories;
    }
}
