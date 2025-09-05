package Strategies;

import java.util.Arrays;

public class SelectionSort implements SortingStrategy {

    // Copied from "https://www.geeksforgeeks.org/dsa/selection-sort-algorithm-2/"
    // On each iteration the algorithm moves from the current "i" position,
    // to the index position farthest to the right,
    // finding the smallest value and swapping the values out.
    // e.g. [8, 5, 9, 1] = [1, 5, 9, 8]

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < (n - 1); i++) {
            int min = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}

