// ============================================================
// Lab 5 - Exercise solutions
// File: AnimalDemo.java  (Basic: polymorphic array of animals)
// Student: Ronald Murape (H250475V)
// ============================================================
class AnimalL5B {
    void sound() { System.out.println("Some sound"); }
}

class CatL5 extends AnimalL5B { @Override void sound() { System.out.println("Meow"); } }
class CowL5 extends AnimalL5B { @Override void sound() { System.out.println("Moo"); } }
class DuckL5 extends AnimalL5B { @Override void sound() { System.out.println("Quack"); } }

public class AnimalDemo {
    public static void main(String[] args) {
        AnimalL5B[] animals = { new CatL5(), new CowL5(), new DuckL5() };
        for (AnimalL5B a : animals) a.sound();
    }
}
