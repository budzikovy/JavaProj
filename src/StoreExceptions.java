public class StoreExceptions {

    public static class ProductOutOfStockException extends Exception {
        public ProductOutOfStockException(String message) {
            super(message);
        }
    }

    public static class OrderProcessingException extends Exception {
        public OrderProcessingException(String message) {
            super(message);
        }
    }

}
