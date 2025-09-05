public class ArrayGenerator {
    private int[] smallArray;
    private int[] largeArray;

    public ArrayGenerator(int small, int large) {
        initializeSmallArray(small);
        initializeLargeArray(large);
    }

    public void initializeLargeArray(int size) {
        largeArray = new int[size];

        for (int i = 0; i < size; i++) {
            largeArray[i] = (int) (Math.random() * 10000);
        }
    }

    public void initializeSmallArray(int size) {
        smallArray = new int[size];

        for (int i = 0; i < size; i++) {
            smallArray[i] = (int) (Math.random() * 100000);
        }
    }

    public int[] getLargeArray() {
        return largeArray;
    }

    public int[] getSmallArray() {
        return smallArray;
    }
}
