package second_version;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Smartphone extends Product {

    private String color;
    private int batteryCapacity;
    private List<String> accessories;
    private double accessoriesCost;

    public Smartphone(int id, String name, double price, int availableQuantity, String type, String color, int batteryCapacity) {
        super(id, name, price, availableQuantity, type);
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = new ArrayList<>();
        this.accessoriesCost = 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public List<String> getAccessories() {
        return accessories;
    }

    public void addAccessory(String accessory, double cost) {
        this.accessories.add(accessory);
        this.accessoriesCost += cost;
    }

    public double getAccessoriesCost() {
        return accessoriesCost;
    }

    public void configureSpecs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Configure your smartphone:");

        // Choose color
        System.out.println("Choose color:");
        System.out.println("1: BLACK");
        System.out.println("2: WHITE");
        System.out.println("3: BLUE");
        System.out.println("4: RED");
        System.out.println("5: GREEN");
        int colorChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (colorChoice) {
            case 1:
                this.setColor(SmartphoneSpecifications.Color.BLACK.name());
                break;
            case 2:
                this.setColor(SmartphoneSpecifications.Color.WHITE.name());
                break;
            case 3:
                this.setColor(SmartphoneSpecifications.Color.BLUE.name());
                break;
            case 4:
                this.setColor(SmartphoneSpecifications.Color.RED.name());
                break;
            case 5:
                this.setColor(SmartphoneSpecifications.Color.GREEN.name());
                break;
            default:
                System.out.println("Invalid choice. Keeping current: " + this.color);
        }

        // Prices for accessories
        Map<String, Double> accessoryPrices = new HashMap<>();
        accessoryPrices.put(SmartphoneSpecifications.Accessory.CASE.name(), 50.0);
        accessoryPrices.put(SmartphoneSpecifications.Accessory.SCREEN_PROTECTOR.name(), 20.0);
        accessoryPrices.put(SmartphoneSpecifications.Accessory.CHARGER.name(), 10.0);
        accessoryPrices.put(SmartphoneSpecifications.Accessory.EARBUDS.name(), 250.0);

        // Choose accessories
        boolean addMoreAccessories = true;
        List<String> availableAccessories = new ArrayList<>(accessoryPrices.keySet());

        while (addMoreAccessories && !availableAccessories.isEmpty()) {
            System.out.println("Choose accessories (current: " + this.accessories + "):");
            for (int i = 0; i < availableAccessories.size(); i++) {
                System.out.println((i + 1) + ": " + availableAccessories.get(i) + " ($" + accessoryPrices.get(availableAccessories.get(i)) + ")");
            }
            int accessoryChoice = scanner.nextInt();
            scanner.nextLine();

            if (accessoryChoice > 0 && accessoryChoice <= availableAccessories.size()) {
                String chosenAccessory = availableAccessories.get(accessoryChoice - 1);
                this.addAccessory(chosenAccessory, accessoryPrices.get(chosenAccessory));
                availableAccessories.remove(accessoryChoice - 1);

                System.out.println("Accessory added: " + chosenAccessory);
            } else {
                System.out.println("Invalid choice.");
            }

            if (!availableAccessories.isEmpty()) {
                System.out.println("Do you want to add another accessory? (yes/no)");
                String addMore = scanner.nextLine();
                if (!addMore.equalsIgnoreCase("yes")) {
                    addMoreAccessories = false;
                }
            }
        }

        System.out.println("Configuration updated: " + this.toString());
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "color='" + color + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", accessories=" + accessories +
                ", accessoriesCost=" + accessoriesCost +
                "} " + super.toString();
    }
}
