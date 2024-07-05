package second_version;

import java.util.Scanner;

public class Computer extends Product {

    private String processor;
    private int ram;
    private int storage;

    public Computer(int id, String name, double price, int availableQuantity, String type, String processor, int ram, int storage) {
        super(id, name, price, availableQuantity, type);
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void configureSpecs() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Configure your computer:");

        // Choose processor brand
        System.out.println("Choose processor brand:");
        System.out.println("1: AMD");
        System.out.println("2: Intel");
        int processorBrandChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (processorBrandChoice == 1) {
            // Choose AMD processor
            System.out.println("Choose AMD processor:");
            System.out.println("1: RYZEN_3");
            System.out.println("2: RYZEN_5");
            System.out.println("3: RYZEN_7");
            int amdProcessorChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (amdProcessorChoice) {
                case 1:
                    this.setProcessor(Processors.AMDProcessor.RYZEN_3.name());
                    break;
                case 2:
                    this.setProcessor(Processors.AMDProcessor.RYZEN_5.name());
                    break;
                case 3:
                    this.setProcessor(Processors.AMDProcessor.RYZEN_7.name());
                    break;
                default:
                    System.out.println("Invalid choice. Keeping current: " + this.processor);
            }
        } else if (processorBrandChoice == 2) {
            // Choose Intel processor
            System.out.println("Choose Intel processor:");
            System.out.println("1: I3");
            System.out.println("2: I5");
            System.out.println("3: I7");
            int intelProcessorChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (intelProcessorChoice) {
                case 1:
                    this.setProcessor(Processors.IntelProcessor.I3.name());
                    break;
                case 2:
                    this.setProcessor(Processors.IntelProcessor.I5.name());
                    break;
                case 3:
                    this.setProcessor(Processors.IntelProcessor.I7.name());
                    break;
                default:
                    System.out.println("Invalid choice. Keeping current: " + this.processor);
            }
        } else {
            System.out.println("Invalid brand choice. Keeping current processor: " + this.processor);
        }

        // Choose RAM
        System.out.print("Choose RAM size in GB (current: " + this.ram + "): ");
        int newRam = scanner.nextInt();
        if (newRam > 0) {
            this.setRam(newRam);
        }

        // Choose storage
        System.out.print("Choose storage size in GB (current: " + this.storage + "): ");
        int newStorage = scanner.nextInt();
        if (newStorage > 0) {
            this.setStorage(newStorage);
        }

        System.out.println("Configuration updated: " + this.toString());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                "} " + super.toString();
    }
}