package algorithms;

import utils.Metrics;

import java.util.Random;

public class QuickSort {
    private static Random random = new Random();

    public static void sort(int[] arr) {
        Metrics.reset();
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        Metrics.enterRecursion();

        while (low < high) {
            int pivot = partition(arr, low, high);
            if (pivot - low < high - pivot) {
                quickSort(arr, low, pivot - 1);
                low = pivot + 1;
            }
            else {
                quickSort(arr, pivot + 1, high);
                high = pivot - 1;
            }
        }
        Metrics.exitRecursion();
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = low + random.nextInt(high - low + 1);
        swap(arr, pivotIndex, high);
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            Metrics.countComparisons();
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
