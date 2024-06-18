public class Smartphone extends Product{

    private String color;
    private int batteryCapacity;
    private String accessories;

    public Smartphone(int id, String name, double price, int availableQuant, String color, int batteryCapacity, String accessories) {
        super(id, name, price, availableQuant, "Smartphone");
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
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

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public void configureSpecifications(String color, int batteryCapacity, String accessories) {
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return super.toString() + " Smartphone [color=" + color + ", batteryCapacity=" + batteryCapacity + ", accessories=" + accessories + "]";
    }

}
