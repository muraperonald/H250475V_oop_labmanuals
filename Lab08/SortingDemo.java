// ============================================================
// Lab 8 - Generics and Collections
// File: SortingDemo.java
// Student: Ronald Murape (H250475V)
// ============================================================
import java.util.*;

class StudentL8 implements Comparable<StudentL8> {
    private final String name;
    private final double gpa;
    StudentL8(String name, double gpa) { this.name = name; this.gpa = gpa; }
    String getName() { return name; }
    double getGpa()  { return gpa; }
    // EXPLAIN: natural order = by name
    @Override
    public int compareTo(StudentL8 o) { return name.compareTo(o.name); }
    @Override public String toString() { return name + "(" + gpa + ")"; }
}

public class SortingDemo {

    public static void main(String[] args) {
        List<StudentL8> list = new ArrayList<>(List.of(
                new StudentL8("Kuda", 3.2), new StudentL8("Ada", 3.9), new StudentL8("Lynn", 3.5)));
        Collections.sort(list);                             // uses compareTo
        System.out.println("By name: " + list);

        // EXPLAIN: Comparator = an external, alternative ordering
        list.sort(Comparator.comparingDouble(StudentL8::getGpa).reversed());
        System.out.println("By GPA desc: " + list);

        list.sort(Comparator.comparing(StudentL8::getName).reversed());
        System.out.println("By name desc: " + list);
    }
}
