public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Initializer.initializeProducts(productManager);

        CLI cli = new CLI(productManager);
        cli.start();
    }
}
