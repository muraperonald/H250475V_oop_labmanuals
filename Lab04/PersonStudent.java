// ============================================================
// Lab 4 - Exercise solutions
// File: PersonStudent.java  (Basic: Person -> Student)
// Student: Ronald Murape (H250475V)
// ============================================================
class PersonL4 {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class StudentL4 extends PersonL4 {
    String course;
    @Override
    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

class TeacherL4 extends PersonL4 {
    String subject;
    @Override
    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

public class PersonStudent {
    public static void main(String[] args) {
        StudentL4 s = new StudentL4();
        s.name = "Ronald"; s.age = 22; s.course = "OOP";
        TeacherL4 t = new TeacherL4();
        t.name = "Dr Smith"; t.age = 45; t.subject = "Java";
        s.display();
        t.display();
    }
}
