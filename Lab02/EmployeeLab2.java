// ============================================================
// Lab 2 - Exercise solutions
// File: EmployeeLab2.java
// (Intermediate: auto-incrementing id, 3 overloaded constructors, copy constructor)
// Student: Ronald Murape (H250475V)
// ============================================================
public class EmployeeLab2 {

    private static int nextId = 1;

    private final int employeeId;
    private String name;
    private double salary;

    public EmployeeLab2() { this("Unknown", 0.0); }
    public EmployeeLab2(String name) { this(name, 0.0); }
    public EmployeeLab2(String name, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.salary = salary;
    }
    // copy constructor
    public EmployeeLab2(EmployeeLab2 other) {
        this.employeeId = nextId++;
        this.name = other.name;
        this.salary = other.salary;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName()     { return name; }
    public double getSalary()  { return salary; }

    public String toString() {
        return "Employee{id=" + employeeId + ", name=" + name + ", salary=" + salary + "}";
    }

    public static void main(String[] args) {
        EmployeeLab2 e1 = new EmployeeLab2("Tariro", 3500);
        EmployeeLab2 e2 = new EmployeeLab2("Farai");
        EmployeeLab2 e3 = new EmployeeLab2();
        EmployeeLab2 e4 = new EmployeeLab2(e1);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
    }
}
