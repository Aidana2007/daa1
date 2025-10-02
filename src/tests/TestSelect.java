package tests;
import algorithms.QuickSelect;
import utils.Metrics;
import java.util.Arrays;
import java.util.Random;

public class TestSelect {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Testing Deterministic Select...");

        testCorrectness();
        testCompareWithSort();
        testRecursionDepth();
    }

    private static void testCorrectness() {
        for (int t = 0; t < 10; t++) {
            int n = 100;
            int[] arr = randomArray(n);
            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            int k = random.nextInt(n);
            int result = QuickSelect.select(arr, k);
            int expected = sorted[k];

            if (result != expected) {
                System.out.println("Test failed: k=" + k + " got " + result + " expected " + expected);
                return;
            }
        }
        System.out.println("All correctness tests passed.");
    }

    private static void testCompareWithSort() {
        int n = 1000;
        int[] arr = randomArray(n);
        int[] arrCopy = arr.clone();

        int k = n / 2;
        int selectResult = QuickSelect.select(arr, k);

        Arrays.sort(arrCopy);
        int sortResult = arrCopy[k];

        System.out.println("Select vs Arrays.sort: " + (selectResult == sortResult ? "MATCH" : "MISMATCH"));
        System.out.println("Comparisons: " + Metrics.comparisons);
    }

    private static void testRecursionDepth() {
        int n = 1000;
        int[] arr = randomArray(n);
        QuickSelect.select(arr, n / 2);

        System.out.println("Max recursion depth: " + Metrics.maxDepth + " (should be O(log n))");
    }

    private static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }
}