package algorithms;
import utils.Metrics;
import java.util.Arrays;

public class ClosestPair {

    public static double findClosestDistance(Point[] points) {
        Metrics.reset();
        if (points == null || points.length < 2) {
            return Double.POSITIVE_INFINITY;
        }

        Point[] pointsByX = points.clone();
        Arrays.sort(pointsByX);

        return closestUtil(pointsByX, 0, points.length - 1);
    }

    private static double closestUtil(Point[] pointsByX, int left, int right) {
        Metrics.enterRecursion();

        int n = right - left + 1;

        if (n <= 1) {
            Metrics.exitRecursion();
            return Double.POSITIVE_INFINITY;
        }
        if (n == 2) {
            Metrics.exitRecursion();
            return pointsByX[left].distanceTo(pointsByX[right]);
        }
        if (n == 3) {
            double d1 = pointsByX[left].distanceTo(pointsByX[left + 1]);
            double d2 = pointsByX[left].distanceTo(pointsByX[right]);
            double d3 = pointsByX[left + 1].distanceTo(pointsByX[right]);
            Metrics.exitRecursion();
            return Math.min(d1, Math.min(d2, d3));
        }

        int mid = left + (right - left) / 2;
        Point midPoint = pointsByX[mid];

        double leftMin = closestUtil(pointsByX, left, mid);
        double rightMin = closestUtil(pointsByX, mid + 1, right);
        double minDistance = Math.min(leftMin, rightMin);

        minDistance = checkStrip(pointsByX, left, right, midPoint, minDistance);

        Metrics.exitRecursion();
        return minDistance;
    }

    private static double checkStrip(Point[] points, int left, int right, Point midPoint, double minDist) {

        Point[] strip = new Point[right - left + 1];
        int stripSize = 0;

        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDist) {
                strip[stripSize++] = points[i];
            }
        }

        Arrays.sort(strip, 0, stripSize, (a, b) -> Double.compare(a.y, b.y));

        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < minDist; j++) {
                Metrics.countComparisons();
                double dist = strip[i].distanceTo(strip[j]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }

        return minDist;
    }
}