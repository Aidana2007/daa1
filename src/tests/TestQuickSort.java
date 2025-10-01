package tests;

import algorithms.QuickSort;
import utils.Metrics;
import java.util.Arrays;
import java.util.Random;

public class TestQuickSort {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Testing QuickSort...");

        testCorrectnessRandom();
        testCorrectnessAdversarial();
        testRecursionDepth();
    }

    private static void testCorrectnessRandom() {
        for (int t = 0; t < 10; t++) {
            int n = 50;
            int[] arr = randomArray(n);
            int[] expected = arr.clone();
            Arrays.sort(expected);

            QuickSort.sort(arr);

            if (!Arrays.equals(arr, expected)) {
                System.out.println("Random test failed: " + Arrays.toString(arr));
                return;
            }
        }
        System.out.println("Random correctness tests passed.");
    }

    private static void testCorrectnessAdversarial() {
        int n = 50;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        int[] expected = arr.clone();

        QuickSort.sort(arr);

        if (!Arrays.equals(arr, expected)) {
            System.out.println("Adversarial test failed!");
        } else {
            System.out.println("Adversarial correctness test passed.");
        }
    }

    private static void testRecursionDepth() {
        int n = 1000;
        int[] arr = randomArray(n);
        QuickSort.sort(arr);

        int bound = 2 * (int) (Math.log(n) / Math.log(2)) + 5;
        System.out.println("Max recursion depth: " + Metrics.maxDepth + " (bound ≈ " + bound + ")");
    }

    private static int[] randomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }
}
