// ============================================================
// Lab 6 - Exercise solutions
// File: ShapeExercise.java  (Basic: abstract Shape)
// Student: Ronald Murape (H250475V)
// ============================================================
abstract class ShapeL6 {
    abstract double area();
    abstract double perimeter();
}

class CircleL6 extends ShapeL6 {
    private final double r;
    CircleL6(double r) { this.r = r; }
    @Override double area() { return Math.PI * r * r; }
    @Override double perimeter() { return 2 * Math.PI * r; }
}

class RectangleL6 extends ShapeL6 {
    private final double w, h;
    RectangleL6(double w, double h) { this.w = w; this.h = h; }
    @Override double area() { return w * h; }
    @Override double perimeter() { return 2 * (w + h); }
}

class SquareL6 extends RectangleL6 {
    SquareL6(double s) { super(s, s); }
}

public class ShapeExercise {
    public static void main(String[] args) {
        ShapeL6[] shapes = { new CircleL6(3), new RectangleL6(4, 5), new SquareL6(6) };
        for (ShapeL6 s : shapes) {
            System.out.printf("%-12s area=%.2f perimeter=%.2f%n",
                    s.getClass().getSimpleName(), s.area(), s.perimeter());
        }
    }
}
