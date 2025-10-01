package utils;

public class Metrics {
    public static int comparisons = 0;
    public static int recursionDepth = 0;
    public static int maxDepth = 0;

    public static void reset() {
        comparisons = 0;
        recursionDepth = 0;
        maxDepth = 0;
    }

    public static void enterRecursion() {
        recursionDepth++;
        if (recursionDepth > maxDepth) {
            maxDepth = recursionDepth;
        }
    }

    public static void exitRecursion() {
        recursionDepth--;
    }

    public static void countComparisons() {
        comparisons++;
    }
}