// ============================================================
// Lab 4 - Inheritance
// File: Employee.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class Employee {

    private final String name;
    protected double baseSalary;      // EXPLAIN: protected -> visible to subclasses

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        System.out.println("Employee constructor: " + name);
    }

    public String getName() { return name; }

    public double calculatePay() {
        return baseSalary;
    }

    public void describe() {
        System.out.printf("%s earns %.2f%n", name, calculatePay());
    }
}
