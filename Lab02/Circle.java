// ============================================================
// Lab 2 - Exercise solutions
// File: Circle.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class Circle {

    private double radius;
    private static int count = 0;

    public Circle() { this(1.0); }          // no-arg delegates to main constructor
    public Circle(double radius) { this.radius = radius; count++; }

    public double getRadius() { return radius; }
    public double area()      { return Math.PI * radius * radius; }

    public static int getCount() { return count; }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.0);
        System.out.println("c1 radius=" + c1.getRadius() + " area=" + c1.area());
        System.out.println("c2 radius=" + c2.getRadius() + " area=" + c2.area());
        System.out.println("Circles created: " + Circle.getCount());
    }
}
