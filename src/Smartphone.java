import java.util.Set;

public class Smartphone extends Product {

    private SmartphoneSpecifications.Color color;
    private SmartphoneSpecifications.BatteryCapacity batteryCapacity;
    private Set<SmartphoneSpecifications.Accessory> accessories;

    public Smartphone(int id, String name, double price, int availableQuant, SmartphoneSpecifications.Color color, SmartphoneSpecifications.BatteryCapacity batteryCapacity, Set<SmartphoneSpecifications.Accessory> accessories) {
        super(id, name, price, availableQuant, "Smartphone");
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    public SmartphoneSpecifications.Color getColor() {
        return color;
    }

    public void setColor(SmartphoneSpecifications.Color color) {
        this.color = color;
    }

    public SmartphoneSpecifications.BatteryCapacity getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(SmartphoneSpecifications.BatteryCapacity batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Set<SmartphoneSpecifications.Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<SmartphoneSpecifications.Accessory> accessories) {
        this.accessories = accessories;
    }

    public void configureSpecifications(SmartphoneSpecifications.Color color, SmartphoneSpecifications.BatteryCapacity batteryCapacity, Set<SmartphoneSpecifications.Accessory> accessories) {
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return super.toString() + " Smartphone [color=" + color + ", batteryCapacity=" + batteryCapacity.getCapacity() + "mAh, accessories=" + accessories + "]";
    }
}
