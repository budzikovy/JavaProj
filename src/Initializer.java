import java.util.EnumSet;
import java.util.Set;

public class Initializer {

    public static void initializeProducts(ProductManager productManager) {
        Computer comp = new Computer(1, "Laptop", 1500.0, 10, ComputerSpecifications.Processor.INTEL_I7, ComputerSpecifications.RAM.RAM_16GB, ComputerSpecifications.Storage.STORAGE_512GB);
        Set<SmartphoneSpecifications.Accessory> accessories = EnumSet.of(SmartphoneSpecifications.Accessory.CASE, SmartphoneSpecifications.Accessory.CHARGER);
        Smartphone phone = new Smartphone(2, "Smartphone", 800.0, 20, SmartphoneSpecifications.Color.BLACK, SmartphoneSpecifications.BatteryCapacity.BATTERY_3000MAH, accessories);
        Electronics tv = new Electronics(3, "Television", 1200.0, 15);

        productManager.addProduct(comp);
        productManager.addProduct(phone);
        productManager.addProduct(tv);
    }
}
