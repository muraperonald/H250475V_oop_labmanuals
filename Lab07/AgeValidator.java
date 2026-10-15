// ============================================================
// Lab 7 - Exercise solutions
// File: AgeValidator.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class AgeValidator {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age must be in 0..120, got " + age);
        }
    }

    public static void main(String[] args) {
        int[] tests = {25, -5, 150};
        for (int a : tests) {
            try {
                validateAge(a);
                System.out.println(a + " is valid");
            } catch (InvalidAgeException e) {
                System.out.println("Rejected " + a + ": " + e.getMessage());
            }
        }
    }
}
