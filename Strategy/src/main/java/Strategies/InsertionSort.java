package Strategies;

public class InsertionSort implements SortingStrategy {

    // Copied from "https://www.geeksforgeeks.org/dsa/insertion-sort-algorithm/"
    // Assigns the current "i" position of the array as a key value.
    // When a smaller number is found in the "sorted array",
    // the algorithm places the key and moves on to the next iteration.
    // e.g. The key value is compared with each value left to it, until it finds a smaller value.
    // i = 3 [7, 9, 10, 1] = [1, 7, 9, 10]

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        //
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}


