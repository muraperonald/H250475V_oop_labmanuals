import java.util.List;

/**
 * Runs the same operations over a mixed list of accounts to show that each
 * object applies its own rules, chosen at runtime.
 */
public class BankDemo {

    // One amount for every account, so any difference in outcome comes purely from the account's own rules
    private static final double WITHDRAWAL_AMOUNT = 250.00;
    private static final double INVALID_DEPOSIT_AMOUNT = -20.00;

    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new SavingsAccount("SAV-001", "Tendai Moyo", 1000.00),
                new CurrentAccount("CUR-001", "Rudo Chikwanha", 100.00, 500.00),
                new SavingsAccount("SAV-002", "Farai Ncube", 200.00),
                new CurrentAccount("CUR-002", "Nyasha Dube", 50.00, 100.00)
        );

        System.out.println("=== Harare Community Bank - Month-End Run (USD) ===");
        System.out.println();

        System.out.println("Input validation check:");
        accounts.get(0).deposit(INVALID_DEPOSIT_AMOUNT);
        System.out.println();

        for (Account account : accounts) {
            System.out.printf("--- %s | %s | %s ---%n",
                    account.getAccountNumber(), account.getAccountType(), account.getAccountHolder());

            System.out.printf("  Balance before withdrawal: %s%n", Account.formatUsd(account.getBalance()));
            account.withdraw(WITHDRAWAL_AMOUNT);
            System.out.printf("  Balance after withdrawal:  %s%n", Account.formatUsd(account.getBalance()));

            System.out.printf("  Balance before month-end:  %s%n", Account.formatUsd(account.getBalance()));
            account.endOfMonth();
            System.out.printf("  Balance after month-end:   %s%n", Account.formatUsd(account.getBalance()));
            System.out.println();
        }

        System.out.println("=== Closing balances ===");
        for (Account account : accounts) {
            System.out.printf("  %s  %-15s %12s%n",
                    account.getAccountNumber(), account.getAccountHolder(), Account.formatUsd(account.getBalance()));
        }
    }
}
