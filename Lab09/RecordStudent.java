// ============================================================
// Lab 9 - Exercise solutions
// File: RecordStudent.java  (Basic: record)
// Student: Ronald Murape (H250475V)
// ============================================================
record StudentRec(String name, int age) { }

public class RecordStudent {
    public static void main(String[] args) {
        StudentRec a = new StudentRec("Ronald", 22);
        StudentRec b = new StudentRec("Ronald", 22);
        System.out.println(a);
        System.out.println("equal? " + a.equals(b));
        System.out.println("name=" + a.name() + ", age=" + a.age());
    }
}
