package algorithms;

public class Point implements Comparable<Point> {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public int compareTo(Point other) {
        return Double.compare(this.x, other.x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}