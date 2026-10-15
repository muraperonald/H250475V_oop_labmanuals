// ============================================================
// Lab 10 - Exercise solutions
// File: StreamExercise.java
// Student: Ronald Murape (H250475V)
// ============================================================
import java.util.*;
import java.util.stream.*;

record StudentX(String name, double gpa) {}

public class StreamExercise {

    public static void main(String[] args) {
        // Predicate + removeIf: delete even numbers
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        nums.removeIf(n -> n % 2 == 0);
        System.out.println("Odd only: " + nums);

        // Students above class average, sorted alphabetically
        List<StudentX> students = List.of(
                new StudentX("Kuda", 3.2), new StudentX("Ada", 3.9),
                new StudentX("Lynn", 3.5), new StudentX("Ben", 2.8));
        double avg = students.stream().mapToDouble(StudentX::gpa).average().orElse(0);
        System.out.printf("Average = %.2f%n", avg);
        students.stream()
                .filter(s -> s.gpa() > avg)
                .map(StudentX::name)
                .sorted()
                .forEach(System.out::println);
    }
}
