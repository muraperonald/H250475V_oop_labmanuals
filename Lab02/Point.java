// ============================================================
// Lab 2 - Constructors, this, static
// File: Point.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class Point {

    private final int x, y;

    public Point(int x, int y) { this.x = x; this.y = y; }

    // EXPLAIN: copy constructor creates an independent object with the same values
    public Point(Point other) { this(other.x, other.y); }

    public String toString() { return "(" + x + ", " + y + ")"; }

    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(p1);   // a true copy, not an alias
        System.out.println(p1 + " " + p2 + " same object? " + (p1 == p2));
    }
}
