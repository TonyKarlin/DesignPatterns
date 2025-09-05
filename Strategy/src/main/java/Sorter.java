import Strategies.SelectionSort;
import Strategies.SortingStrategy;

public class Sorter {
    private final SortingContext context;

    public Sorter() {
        this.context = new SortingContext(new SelectionSort());
    }

    public void compareWithCustomSampleSize(SortingStrategy strategy, int[] array) {
        System.out.println("Current strategy: " + strategy.getClass().getSimpleName());
        if (array.length >= 1000) System.out.println("Sample size: Large");
        else System.out.println("Sample size: Small");

        context.setStrategy(strategy);
        long startTime = System.nanoTime();
        context.sortArray(array);

        String endTime = "Time spent sorting " + "(" + strategy.getClass().getSimpleName()
                + "): " + (System.nanoTime() - startTime) + " nanoseconds\n";
        System.out.println(endTime);
    }
}
