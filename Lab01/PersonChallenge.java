// ============================================================
// Lab 1 - Exercise solutions
// File: PersonChallenge.java  (Challenge: Person HAS-A Address)
// Student: Ronald Murape (H250475V)
// ============================================================
class Address {
    String city;
    String country;
}

class Person {
    String name;
    Address address;   // EXPLAIN: holds a reference, may be null
}

public class PersonChallenge {

    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Ronald";
        Address a = new Address();
        a.city = "Harare";
        a.country = "Zimbabwe";
        p.address = a;

        System.out.println(p.name + " lives in " + p.address.city);   // chained dot

        // null address case
        Person q = new Person();
        q.name = "Moyo";
        q.address = null;
        if (q.address == null) {
            System.out.println(q.name + " has no address on file (NullPointerException avoided)");
        }
    }
}
