import Strategies.CountSort;
import Strategies.InsertionSort;
import Strategies.SelectionSort;
import Strategies.SortingStrategy;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        SortingStrategy selection = new SelectionSort();
        SortingStrategy insertion = new InsertionSort();
        SortingStrategy count = new CountSort();
        ArrayGenerator aG = new ArrayGenerator(50, 100000);

        sorter.compareWithCustomSampleSize(selection, aG.getSmallArray());
        sorter.compareWithCustomSampleSize(insertion, aG.getSmallArray());
        sorter.compareWithCustomSampleSize(count, aG.getSmallArray());

        sorter.compareWithCustomSampleSize(selection, aG.getLargeArray());
        sorter.compareWithCustomSampleSize(insertion, aG.getLargeArray());
        sorter.compareWithCustomSampleSize(count, aG.getLargeArray());
    }
}
