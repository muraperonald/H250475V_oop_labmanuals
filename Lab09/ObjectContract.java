// ============================================================
// Lab 9 - Nested Types, Enums, Records
// File: ObjectContract.java
// Student: Ronald Murape (H250475V)
// ============================================================
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class PointL9 {
    private final int x, y;
    PointL9(int x, int y) { this.x = x; this.y = y; }

    // EXPLAIN: equality by VALUE instead of by reference
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                    // same reference
        if (!(o instanceof PointL9 other)) return false; // null or wrong type
        return x == other.x && y == other.y;
    }

    // EXPLAIN: equal objects MUST produce equal hash codes
    @Override
    public int hashCode() { return Objects.hash(x, y); }

    @Override
    public String toString() { return "Point(" + x + ", " + y + ")"; }
}

// The same idea with almost no code: a record
record Coordinate(int x, int y) {
    // compact constructor: validation
    Coordinate {
        if (x < 0 || y < 0) throw new IllegalArgumentException("Negative coordinate");
    }

    double distanceFromOrigin() { return Math.sqrt(x * x + y * y); }
}

public class ObjectContract {

    public static void main(String[] args) {
        PointL9 p1 = new PointL9(1, 2);
        PointL9 p2 = new PointL9(1, 2);
        System.out.println(p1 == p2);          // false (different objects)
        System.out.println(p1.equals(p2));     // true  (same values)

        Set<PointL9> set = new HashSet<>();
        set.add(p1);
        set.add(p2);                           // duplicate by equals/hashCode
        System.out.println("Set size: " + set.size());   // 1
        System.out.println(p1);

        Coordinate c1 = new Coordinate(3, 4);
        Coordinate c2 = new Coordinate(3, 4);
        System.out.println(c1);                          // generated toString
        System.out.println(c1.equals(c2));               // generated equals
        System.out.println(c1.x() + " " + c1.distanceFromOrigin());   // accessor: x()
    }
}
