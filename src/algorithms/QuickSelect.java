package algorithms;
import utils.Metrics;
import utils.ArrayUtils;

public class QuickSelect {

    public static int select(int[] arr, int k) {
        Metrics.reset();
        if (arr == null || arr.length == 0 || k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        Metrics.enterRecursion();

        while (left < right) {
            if (right - left + 1 <= 10) {
                ArrayUtils.insertionSort(arr, left, right);
                int result = arr[left + k];
                Metrics.exitRecursion();
                return result;
            }

            int pivotIndex = medianOfMedians(arr, left, right);
            pivotIndex = ArrayUtils.partition(arr, left, right, pivotIndex);

            if (k == pivotIndex) {
                Metrics.exitRecursion();
                return arr[k];
            } else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                k = k - pivotIndex - 1;
                left = pivotIndex + 1;
            }
        }

        Metrics.exitRecursion();
        return arr[left];
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        int numGroups = (n + 4) / 5; // ceil(n/5)

        for (int i = 0; i < numGroups; i++) {
            int groupLeft = left + i * 5;
            int groupRight = Math.min(groupLeft + 4, right);
            int medianIndex = findMedianOfFive(arr, groupLeft, groupRight);

            ArrayUtils.swap(arr, left + i, medianIndex);
        }

        int k = numGroups / 2;
        return quickSelect(arr, left, left + numGroups - 1, k);
    }

    private static int findMedianOfFive(int[] arr, int left, int right) {

        ArrayUtils.insertionSort(arr, left, right);
        return left + (right - left) / 2;
    }
}