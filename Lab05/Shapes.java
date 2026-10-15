// ============================================================
// Lab 5 - Polymorphism
// File: Shapes.java  (overriding + upcasting)
// Student: Ronald Murape (H250475V)
// ============================================================
class Shape {
    String name() { return "Generic shape"; }
    double area() { return 0; }
}

class CircleL5 extends Shape {
    private final double r;
    CircleL5(double r) { this.r = r; }
    @Override String name() { return "Circle"; }
    @Override double area() { return Math.PI * r * r; }
}

class RectangleL5 extends Shape {
    private final double w, h;
    RectangleL5(double w, double h) { this.w = w; this.h = h; }
    @Override String name() { return "Rectangle"; }
    @Override double area() { return w * h; }
}

class TriangleL5 extends Shape {
    private final double b, h;
    TriangleL5(double b, double h) { this.b = b; this.h = h; }
    @Override String name() { return "Triangle"; }
    @Override double area() { return 0.5 * b * h; }
}

public class Shapes {
    public static void main(String[] args) {
        // EXPLAIN: upcasting -> one array type holds many different subclass objects
        Shape[] shapes = {
            new CircleL5(5),
            new RectangleL5(4, 6),
            new TriangleL5(3, 8)
        };
        double total = 0;
        for (Shape s : shapes) {
            // EXPLAIN: JVM picks name()/area() from the ACTUAL object at run time
            System.out.printf("%-10s area = %.2f%n", s.name(), s.area());
            total += s.area();
        }
        System.out.printf("Total area = %.2f%n", total);
    }
}
