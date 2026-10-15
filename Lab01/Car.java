// ============================================================
// Lab 1 - Exercise solutions
// File: Car.java  (Basic: Car with brand, year, mileage)
// Student: Ronald Murape (H250475V)
// ============================================================
public class Car {

    String brand;
    int year;
    double mileage;

    void display() {
        System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage);
    }

    // EXPLAIN: returns true when the car is more than 25 years old
    boolean isAntique() {
        int currentYear = 2026;
        return (currentYear - year) > 25;
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.year = 1990;
        c1.mileage = 150000;

        Car c2 = new Car();
        c2.brand = "BMW";
        c2.year = 2010;
        c2.mileage = 80000;

        Car c3 = new Car();
        c3.brand = "Ford";
        c3.year = 2020;
        c3.mileage = 30000;

        c1.display();
        c2.display();
        c3.display();

        System.out.println(c1.brand + " antique? " + c1.isAntique());
        System.out.println(c2.brand + " antique? " + c2.isAntique());
        System.out.println(c3.brand + " antique? " + c3.isAntique());
    }
}
