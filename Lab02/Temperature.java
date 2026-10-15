// ============================================================
// Lab 2 - Exercise solutions (Challenge)
// File: Temperature.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class Temperature {

    private final double celsius;

    private Temperature(double celsius) { this.celsius = celsius; }

    public static Temperature fromCelsius(double c) { return new Temperature(c); }
    public static Temperature fromFahrenheit(double f) { return new Temperature((f - 32) * 5.0 / 9.0); }

    public double getCelsius()    { return celsius; }
    public double getFahrenheit() { return celsius * 9.0 / 5.0 + 32; }

    public String toString() { return String.format("%.2f C (%.2f F)", celsius, getFahrenheit()); }

    public static void main(String[] args) {
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2 = Temperature.fromFahrenheit(32);
        System.out.println(t1);
        System.out.println(t2);
    }
}
