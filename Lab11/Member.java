// ============================================================
// Lab 11 Mini-Project
// File: Member.java
// Student: Ronald Murape (H250475V)
// ============================================================
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private final String id;
    private final String name;
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId()   { return id; }
    public String getName() { return name; }

    public void addLoan(Loan l)     { loans.add(l); }
    public void removeLoan(Loan l)  { loans.remove(l); }
    public List<Loan> getLoans()    { return Collections.unmodifiableList(loans); }
    public boolean hasReachedLimit() { return loans.size() >= 3; }

    @Override
    public String toString() {
        return id + " - " + name + " (loans: " + loans.size() + ")";
    }
}
