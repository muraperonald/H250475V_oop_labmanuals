/**
 * A current (cheque) account may go overdrawn up to an agreed limit and pays
 * a flat maintenance fee instead of earning interest.
 */
public class CurrentAccount extends Account {

    private static final double MONTHLY_MAINTENANCE_FEE = 2.50;
    private static final double MAX_OVERDRAFT_LIMIT = 1000.00;

    // Per-account because the bank agrees an overdraft with each customer individually
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double openingBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, openingBalance);
        if (overdraftLimit < 0 || overdraftLimit > MAX_OVERDRAFT_LIMIT) {
            throw new IllegalArgumentException("Overdraft limit must be between $0.00 and "
                    + formatUsd(MAX_OVERDRAFT_LIMIT) + ".");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (!isValidAmount(amount)) {
            System.out.printf("  REJECTED: withdrawal of %s from %s - amount must be greater than zero.%n",
                    formatUsd(amount), accountNumber);
            return false;
        }
        double balanceAfter = balance - amount;
        // The overdraft limit is a floor of -overdraftLimit, not a cap on a single withdrawal
        if (balanceAfter < -overdraftLimit) {
            System.out.printf("  REJECTED: withdrawing %s from %s would leave %s, beyond the overdraft limit of %s.%n",
                    formatUsd(amount), accountNumber, formatUsd(balanceAfter), formatUsd(overdraftLimit));
            return false;
        }
        balance = balanceAfter;
        if (balance < 0) {
            System.out.printf("  Withdrew %s from %s - account is now overdrawn by %s (limit %s).%n",
                    formatUsd(amount), accountNumber, formatUsd(-balance), formatUsd(overdraftLimit));
        } else {
            System.out.printf("  Withdrew %s from %s.%n", formatUsd(amount), accountNumber);
        }
        return true;
    }

    @Override
    public void endOfMonth() {
        // The fee is a bank charge, not a customer withdrawal, so it is applied even when overdrawn
        balance -= MONTHLY_MAINTENANCE_FEE;
        System.out.printf("  Month-end: maintenance fee of %s deducted (no interest on current accounts).%n",
                formatUsd(MONTHLY_MAINTENANCE_FEE));
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}
