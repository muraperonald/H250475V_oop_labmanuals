// ============================================================
// Lab 3 - Exercise solutions
// File: ImmutablePerson.java  (Intermediate: immutable class)
// Student: Ronald Murape (H250475V)
// ============================================================
public final class ImmutablePerson {

    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative");
        this.name = name.trim();
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public String toString() { return "ImmutablePerson{name=" + name + ", age=" + age + "}"; }

    public static void main(String[] args) {
        ImmutablePerson p = new ImmutablePerson("Ronald", 22);
        System.out.println(p);
        // final fields + no setters => object cannot change state
    }
}
