public class SmartphoneSpecifications {

    public enum Color {
        WHITE, BLACK, RED, GOLD
    }

    public enum BatteryCapacity {
        BATTERY_3000MAH(3000), BATTERY_4000MAH(4000), BATTERY_5000MAH(5000), BATTERY_6000MAH(6000), BATTERY_6500MAH(6500);

        private final int capacity;

        BatteryCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public enum Accessory {
        CASE, CHARGER, PROTECT_GLASS
    }


}
