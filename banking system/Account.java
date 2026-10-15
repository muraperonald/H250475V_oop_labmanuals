/**
 * Base type for every bank account. Holds the behaviour all accounts share
 * (deposits, balance tracking) and forces each subclass to decide its own
 * withdrawal and month-end rules.
 */
public abstract class Account {

    protected final String accountNumber;
    protected final String accountHolder;
    protected double balance;

    protected Account(String accountNumber, String accountHolder, double openingBalance) {
        // Fail fast: an account with no number or a negative opening balance is a data error, not a user mistake
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number must not be empty.");
        }
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder name must not be empty.");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = openingBalance;
    }

    /** Deposits work identically for every account type, so they live here once. */
    public void deposit(double amount) {
        if (!isValidAmount(amount)) {
            System.out.printf("  REJECTED: deposit of %s into %s - amount must be greater than zero.%n",
                    formatUsd(amount), accountNumber);
            return;
        }
        balance += amount;
        System.out.printf("  Deposited %s into %s.%n", formatUsd(amount), accountNumber);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * Each account type has its own limit on how far the balance may fall.
     *
     * @return true if the withdrawal was applied, false if it was rejected
     */
    public abstract boolean withdraw(double amount);

    /** Hook called by the bank at month-end; subclasses decide what "month-end" means for them. */
    public abstract void endOfMonth();

    /** Lets callers label an account without needing instanceof. */
    public abstract String getAccountType();

    /** Shared so every subclass validates amounts the same way. */
    protected static boolean isValidAmount(double amount) {
        // NaN and infinity would silently corrupt the balance, so treat them as invalid too
        return amount > 0 && Double.isFinite(amount);
    }

    /** Puts the minus sign before the currency symbol so overdrawn balances read naturally. */
    public static String formatUsd(double amount) {
        String formatted = String.format("$%,.2f", Math.abs(amount));
        return amount < 0 ? "-" + formatted : formatted;
    }
}
