// ============================================================
// Lab 11 Mini-Project
// File: Loan.java
// Student: Ronald Murape (H250475V)
// ============================================================
import java.time.LocalDate;

public class Loan {

    private final Member member;
    private final LibraryItem item;
    private final LocalDate dueDate;

    public Loan(Member member, LibraryItem item) {
        this.member = member;
        this.item = item;
        this.dueDate = LocalDate.now().plusDays(item.loanPeriodDays());
    }

    public Loan(Member member, LibraryItem item, LocalDate dueDate) {
        this.member = member;
        this.item = item;
        this.dueDate = dueDate;
    }

    public Member getMember()         { return member; }
    public LibraryItem getItem()       { return item; }
    public LocalDate getDueDate()      { return dueDate; }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return member.getName() + " -> " + item.getTitle() + " (due " + dueDate + ")" +
               (isOverdue() ? " [OVERDUE]" : "");
    }
}
