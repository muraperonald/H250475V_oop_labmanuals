/**
 * A savings account must always keep a minimum balance and earns interest
 * at month-end.
 */
public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 50.00;
    private static final double MONTHLY_INTEREST_RATE = 0.01; // 1% per month

    public SavingsAccount(String accountNumber, String accountHolder, double openingBalance) {
        super(accountNumber, accountHolder, openingBalance);
        // Opening below the minimum would put the account in a state withdraw() is designed to prevent
        if (openingBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Savings accounts must open with at least "
                    + formatUsd(MINIMUM_BALANCE) + ".");
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (!isValidAmount(amount)) {
            System.out.printf("  REJECTED: withdrawal of %s from %s - amount must be greater than zero.%n",
                    formatUsd(amount), accountNumber);
            return false;
        }
        double balanceAfter = balance - amount;
        if (balanceAfter < MINIMUM_BALANCE) {
            System.out.printf("  REJECTED: withdrawing %s from %s would leave %s, below the minimum balance of %s.%n",
                    formatUsd(amount), accountNumber, formatUsd(balanceAfter), formatUsd(MINIMUM_BALANCE));
            return false;
        }
        balance = balanceAfter;
        System.out.printf("  Withdrew %s from %s.%n", formatUsd(amount), accountNumber);
        return true;
    }

    @Override
    public void endOfMonth() {
        // Round to whole cents so the stored balance always matches what the customer sees on a statement
        double interest = Math.round(balance * MONTHLY_INTEREST_RATE * 100) / 100.0;
        balance += interest;
        System.out.printf("  Month-end: interest of %s credited at %.1f%%.%n",
                formatUsd(interest), MONTHLY_INTEREST_RATE * 100);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
