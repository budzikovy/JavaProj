package second_version;

public class Shop {
    public static void main(String[] args) {
//        Computer myComputer = new Computer(1, "Gaming PC", 1500.00, 5, "Desktop", "Intel i7", 16, 512);
//        System.out.println("Initial configuration: " + myComputer.toString());
//        myComputer.configureSpecs();

        Smartphone mySmartphone = new Smartphone(1, "SuperPhone", 999.99, 10, "Smartphone", "BLACK", 4000);
        System.out.println("Initial configuration: " + mySmartphone.toString());
        mySmartphone.configureSpecs();
        System.out.println("Final configuration: " + mySmartphone.toString());

    }
}
