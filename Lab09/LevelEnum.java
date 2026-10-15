// ============================================================
// Lab 9 - Exercise solutions
// File: LevelEnum.java  (Basic: enum + switch)
// Student: Ronald Murape (H250475V)
// ============================================================
enum Level { LOW, MEDIUM, HIGH }

public class LevelEnum {
    static String advice(Level l) {
        return switch (l) {
            case LOW    -> "Take it easy.";
            case MEDIUM -> "Stay focused.";
            case HIGH   -> "Work hard but rest too.";
        };
    }
    public static void main(String[] args) {
        for (Level l : Level.values()) {
            System.out.println(l + ": " + advice(l));
        }
    }
}
