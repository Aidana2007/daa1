package algorithms;

import utils.Metrics;

public class MergeSort {
    private static final int CUTOFF = 15;

    public static void sort(int[] arr) {
        Metrics.reset();
        if (arr == null || arr.length < 2) {
            return;
        }

        int[] buffer = new int[arr.length];
        mergeSort( arr, 0, arr.length - 1, buffer);
    }
    private static void mergeSort(int[] arr, int left, int right, int[] buffer) {
        Metrics.enterRecursion();

        if ( right - left < CUTOFF ) {
            insertSort(arr, left, right);
            Metrics.exitRecursion();
            return;

        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, buffer);
        mergeSort(arr, mid + 1, right, buffer);
        merge(arr, left, mid, right, buffer);

        Metrics.exitRecursion();

    }
    private static void merge(int[] arr, int left, int mid, int right, int[] buffer) {
        for ( int i = left; i <= right; i++) {
            buffer[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            Metrics.countComparisons();
            if (buffer[i] <= buffer[j]) {
                arr[k++] = buffer[i++];
            }
            else {
                arr[k++] = buffer[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = buffer[i++];
        }
    }
    private static void insertSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left) {
                Metrics.countComparisons();
                if (arr[j] > key) {
                    arr[j+1] = arr[j];
                    j--;
                }
                else {
                    break;
                }

            }
            arr[j+1] = key;
        }
    }
}
