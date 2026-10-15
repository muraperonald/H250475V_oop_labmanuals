// ============================================================
// Lab 3 - Exercise solutions
// File: BankAccountTx.java  (Intermediate: account with transaction history)
// Student: Ronald Murape (H250475V)
// ============================================================
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccountTx {

    private final String accNo;
    private double balance;
    private final List<String> history = new ArrayList<>();

    public BankAccountTx(String accNo, double opening) {
        if (opening < 0) throw new IllegalArgumentException("Opening cannot be negative");
        this.accNo = accNo;
        this.balance = opening;
        history.add("OPENED with " + opening);
    }

    public void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amt;
        history.add("DEPOSIT " + amt + " -> balance " + balance);
    }

    public boolean withdraw(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amt > balance) {
            history.add("FAILED WITHDRAW " + amt + " (insufficient)");
            return false;
        }
        balance -= amt;
        history.add("WITHDRAW " + amt + " -> balance " + balance);
        return true;
    }

    public List<String> getHistory() { return Collections.unmodifiableList(history); }
    public double getBalance() { return balance; }

    public static void main(String[] args) {
        BankAccountTx a = new BankAccountTx("A1", 100);
        a.deposit(50);
        a.withdraw(30);
        a.withdraw(200);
        for (String h : a.getHistory()) System.out.println(h);
    }
}
