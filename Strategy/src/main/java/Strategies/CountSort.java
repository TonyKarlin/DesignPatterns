package Strategies;

public class CountSort implements SortingStrategy {

    // Copied from "https://www.geeksforgeeks.org/dsa/counting-sort/"
    // The basic idea behind Counting Sort is to count the frequency of each distinct element in the input array
    // and use that information to place the elements in their correct sorted positions.
    // For example, for input [1, 4, 3, 2, 2, 1], the output should be [1, 1, 2, 2, 3, 4].

    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        // find the maximum element
        int maxval = 0;
        for (int k : arr) if (k > maxval) maxval = k;

        // create and initialize count array
        int[] count = new int[maxval + 1];

        // count frequency of each element
        for (int j : arr) count[j]++;

        // compute prefix sum
        for (int i = 1; i <= maxval; i++)
            count[i] += count[i - 1];

        // build output array
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
//        System.out.println(Arrays.toString(ans));
    }
}
