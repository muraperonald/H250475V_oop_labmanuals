// ============================================================
// Lab 6 - Exercise solutions
// File: AccountAbs.java  (Intermediate: abstract Account with monthlyFee)
// Student: Ronald Murape (H250475V)
// ============================================================
abstract class AccountL6 {
    protected double balance;

    public AccountL6(double opening) {
        if (opening < 0) throw new IllegalArgumentException("Opening cannot be negative");
        this.balance = opening;
    }

    public void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amt;
    }

    // concrete helper
    public double getBalance() { return balance; }

    // abstract fee
    public abstract double monthlyFee();

    public void applyMonthlyFee() { balance -= monthlyFee(); }
}

class SavingsAccount extends AccountL6 {
    SavingsAccount(double opening) { super(opening); }
    @Override public double monthlyFee() { return balance * 0.01; }   // 1%
}

class CurrentAccount extends AccountL6 {
    CurrentAccount(double opening) { super(opening); }
    @Override public double monthlyFee() { return 5.0; }             // flat fee
}

public class AccountAbs {
    public static void main(String[] args) {
        AccountL6 s = new SavingsAccount(1000);
        AccountL6 c = new CurrentAccount(1000);
        s.applyMonthlyFee();
        c.applyMonthlyFee();
        System.out.println("Savings balance: " + s.getBalance());
        System.out.println("Current balance: " + c.getBalance());
    }
}
