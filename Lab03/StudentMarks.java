// ============================================================
// Lab 3 - Exercise solutions
// File: StudentMarks.java  (Basic: private fields + grade)
// Student: Ronald Murape (H250475V)
// ============================================================
public class StudentMarks {

    private String name;
    private int marks;     // 0..100

    public StudentMarks(String name, int marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        this.name = name.trim();
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("Marks 0..100");
        this.marks = marks;
    }

    // EXPLAIN: derived value, not stored -> avoids stale data
    public char getGrade() {
        if (marks >= 75) return 'A';
        if (marks >= 65) return 'B';
        if (marks >= 50) return 'C';
        return 'F';
    }

    public static void main(String[] args) {
        StudentMarks s = new StudentMarks("Ronald", 78);
        System.out.println(s.getName() + " = " + s.getMarks() + " -> " + s.getGrade());
        try { s.setMarks(200); }
        catch (IllegalArgumentException e) { System.out.println("Rejected: " + e.getMessage()); }
    }
}
