package tests;

import algorithms.MergeSort;
import utils.Metrics;

import java.util.Arrays;

public class TestMergeSort {
    public static void main(String[] args) {
        System.out.println("TestMergeSort");

        int[] arr = {5, 2, 8, 1, 9, 3};
        int[] expected = arr.clone();
        Arrays.sort(expected);

        MergeSort.sort(arr);

        System.out.println("Original Array: [5, 2, 8, 1, 9, 3]");
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Arrays match: " + Arrays.equals(arr, expected));
        System.out.println("Compare Arrays: " + Metrics.comparisons);
        System.out.println("Max recursion depth: " + Metrics.maxDepth);
    }
}
