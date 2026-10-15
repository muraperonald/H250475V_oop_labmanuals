// ============================================================
// Lab 5 - Polymorphism
// File: CastingDemo.java
// Student: Ronald Murape (H250475V)
// ============================================================
class AnimalL5 {
    String type = "Animal";                       // field
    void speak() { System.out.println("..."); }
    static void info() { System.out.println("Animal info"); }
}

class DogL5 extends AnimalL5 {
    String type = "Dog";                          // hides the field, does not override it
    @Override void speak() { System.out.println("Woof"); }
    void fetch() { System.out.println("Fetching..."); }
    static void info() { System.out.println("Dog info"); }   // hides, not overrides
}

public class CastingDemo {
    public static void main(String[] args) {
        AnimalL5 a = new DogL5();          // upcast (implicit, always safe)
        a.speak();                     // Woof   -> method IS polymorphic
        System.out.println(a.type);    // Animal -> field follows the DECLARED type
        a.info();                      // Animal info -> static follows declared type
        // a.fetch();                  // COMPILE ERROR: Animal has no fetch()

        // EXPLAIN: downcast needs a check, otherwise ClassCastException is possible
        if (a instanceof DogL5 d) {      // pattern matching (Java 16+): test AND cast
            d.fetch();
        }

        AnimalL5 plain = new AnimalL5();
        if (!(plain instanceof DogL5)) {
            System.out.println("plain is not a Dog; downcast avoided");
        }
    }
}
