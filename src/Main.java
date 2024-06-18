public class Main {
    public static void main(String[] args) {

        ProductManager manager = new ProductManager();

        Computer comp = new Computer(1, "Laptop", 1500.0, 10, "Intel i7", 16, 512);
        Smartphone phone = new Smartphone(2, "Smartphone", 800.0, 20, "Black", 4000, "Earphones");
        Electronics tv = new Electronics(3, "Television", 1200.0, 15);

        manager.addProduct(comp);
        manager.addProduct(phone);
        manager.addProduct(tv);

        System.out.println("All Products:");
        manager.viewProducts()
                .forEach(System.out::println);

        System.out.println("\nUpdating Laptop Configuration:");
        comp.configureSpecifications("Intel i9", 32, 1024);
        manager.updateProduct(1, comp);
        System.out.println(manager.getProductById(1));

        System.out.println("\nCustomizing Smartphone:");
        phone.configureSpecifications("Blue", 5000, "Charger, Earphones");
        manager.updateProduct(2, phone);
        System.out.println(manager.getProductById(2));

        System.out.println("\nRemoving Television:");
        manager.removeProduct(3);
        manager.viewProducts()
                .forEach(System.out::println);

        System.out.println("\nAdding Products to Cart:");
        manager.addProductToCart(1,2);
        manager.addProductToCart(2,1);

//        System.out.println("\n");
        manager.viewCart();

//        System.out.println("\n");
        manager.placeOrder();


    }


}
