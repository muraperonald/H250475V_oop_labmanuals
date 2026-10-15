// ============================================================
// Lab 9 - Exercise solutions (Challenge)
// File: CoinEnum.java  (fewest coins for amount)
// Student: Ronald Murape (H250475V)
// ============================================================
enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private final int cents;
    Coin(int cents) { this.cents = cents; }

    int cents() { return cents; }

    // returns display of fewest coins for amount in cents (greedy, standard US coins)
    static String fewestCoins(int amountCents) {
        StringBuilder sb = new StringBuilder();
        int remaining = amountCents;
        for (Coin c : new Coin[]{QUARTER, DIME, NICKEL, PENNY}) {
            int n = remaining / c.cents;
            if (n > 0) {
                sb.append(n).append(" ").append(c).append("(s) ");
                remaining -= n * c.cents;
            }
        }
        return sb.toString().trim();
    }
}

public class CoinEnum {
    public static void main(String[] args) {
        System.out.println("30c -> " + Coin.fewestCoins(30));
        System.out.println("41c -> " + Coin.fewestCoins(41));
        System.out.println("99c -> " + Coin.fewestCoins(99));
    }
}
