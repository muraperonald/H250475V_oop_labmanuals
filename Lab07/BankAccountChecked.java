// ============================================================
// Lab 7 - Exercise solutions
// File: BankAccountChecked.java
// (Intermediate: withdraw throws checked InsufficientFundsException)
// Student: Ronald Murape (H250475V)
// ============================================================
public class BankAccountChecked {

    private final String accNo;
    private double balance;

    public BankAccountChecked(String accNo, double opening) {
        if (opening < 0) throw new IllegalArgumentException("Opening cannot be negative");
        this.accNo = accNo;
        this.balance = opening;
    }

    public void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amt;
    }

    public void withdraw(double amt) throws InsufficientFundsException {
        if (amt <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amt > balance) {
            throw new InsufficientFundsException("Insufficient funds", amt - balance);
        }
        balance -= amt;
    }

    public double getBalance() { return balance; }

    public static void main(String[] args) {
        BankAccountChecked a = new BankAccountChecked("A1", 100);
        try {
            a.deposit(50);
            System.out.println("Balance: " + a.getBalance());
            a.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage() + "; shortfall=" + e.getShortfall());
        }
        System.out.println("Final balance: " + a.getBalance());
    }
}
