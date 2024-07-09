public class Computer extends Product {

    private ComputerSpecifications.Processor processor;
    private ComputerSpecifications.RAM ram;
    private ComputerSpecifications.Storage storage;

    public Computer(int id, String name, double price, int availableQuant, ComputerSpecifications.Processor processor, ComputerSpecifications.RAM ram, ComputerSpecifications.Storage storage) {
        super(id, name, price, availableQuant, "Computer");
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    public ComputerSpecifications.Processor getProcessor() {
        return processor;
    }

    public void setProcessor(ComputerSpecifications.Processor processor) {
        this.processor = processor;
    }

    public ComputerSpecifications.RAM getRam() {
        return ram;
    }

    public void setRam(ComputerSpecifications.RAM ram) {
        this.ram = ram;
    }

    public ComputerSpecifications.Storage getStorage() {
        return storage;
    }

    public void setStorage(ComputerSpecifications.Storage storage) {
        this.storage = storage;
    }

    public void configureSpecifications(ComputerSpecifications.Processor processor, ComputerSpecifications.RAM ram, ComputerSpecifications.Storage storage) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return super.toString() + " Computer [processor=" + processor + ", ram=" + ram.getSize() + "GB, storage=" + storage.getSize() + "GB]";
    }
}
