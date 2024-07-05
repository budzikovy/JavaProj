public class Initializer {

    public static void initializeProducts(ProductManager productManager) {
        Computer comp = new Computer(1, "Laptop", 1500.0, 10, "Intel i7", 16, 512);
        Smartphone phone = new Smartphone(2, "Smartphone", 800.0, 20, "Black", 4000, "Earphones");
        Electronics tv = new Electronics(3, "Television", 1200.0, 15);

        productManager.addProduct(comp);
        productManager.addProduct(phone);
        productManager.addProduct(tv);
    }
}
