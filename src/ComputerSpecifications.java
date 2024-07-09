public class ComputerSpecifications {

    public enum Processor {
        RYZEN_3, RYZEN_5, RYZEN_7, INTEL_I3, INTEL_I5, INTEL_I7
    }

    public enum RAM {
        RAM_2GB(2), RAM_4GB(4), RAM_8GB(8), RAM_16GB(16), RAM_32GB(32);

        private final int size;

        RAM(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

    public enum Storage {
        STORAGE_256GB(256), STORAGE_512GB(512), STORAGE_1TB(1024), STORAGE_2TB(2048);

        private final int size;

        Storage(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }
    }

}
