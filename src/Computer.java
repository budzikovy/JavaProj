public class Computer extends Product{

    private String processor;
    private int ram;
    private int storage;

    public Computer(int id, String name, double price, int availableQuant, String processor, int ram, int storage) {
        super(id, name, price, availableQuant, "Computer");
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

    public void configureSpecifications(String processor, int ram, int storage) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return super.toString() + " Computer [processor=" + processor + ", ramSize=" + ram + ", storageSize=" + storage + "]";
    }

}
