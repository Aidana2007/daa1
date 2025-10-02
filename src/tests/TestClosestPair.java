package tests;
import algorithms.ClosestPair;
import algorithms.Point;
import utils.Metrics;
import java.util.Random;

public class TestClosestPair {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Testing Closest Pair...");

        testCorrectnessSmall();
        testCompareWithBruteForce();
        testRecursionDepth();
    }

    private static void testCorrectnessSmall() {
        Point[] points = {
                new Point(0, 0),
                new Point(1, 1),
                new Point(3, 3),
                new Point(5, 5)
        };

        double result = ClosestPair.findClosestDistance(points);
        double expected = Math.sqrt(2);

        System.out.println("Small test: result=" + result + " expected=" + expected);
        System.out.println("Small test: " + (Math.abs(result - expected) < 1e-9 ? "PASS" : "FAIL"));
    }

    private static void testCompareWithBruteForce() {
        int n = 100;
        Point[] points = randomPoints(n);

        double fastResult = ClosestPair.findClosestDistance(points);
        double bruteResult = bruteForceClosest(points);

        System.out.println("Fast vs Brute force: " + fastResult + " vs " + bruteResult);
        System.out.println("Match: " + (Math.abs(fastResult - bruteResult) < 1e-9));
        System.out.println("Comparisons: " + Metrics.comparisons);
    }

    private static void testRecursionDepth() {
        int n = 1000;
        Point[] points = randomPoints(n);
        ClosestPair.findClosestDistance(points);

        System.out.println("Max recursion depth: " + Metrics.maxDepth + " (should be O(log n))");
    }

    private static double bruteForceClosest(Point[] points) {
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].distanceTo(points[j]);
                if (dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    private static Point[] randomPoints(int n) {
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(random.nextDouble() * 1000, random.nextDouble() * 1000);
        }
        return points;
    }
}