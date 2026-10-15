// ============================================================
// Lab 7 - Exception Handling
// File: InsufficientFundsException.java
// Student: Ronald Murape (H250475V)
// ============================================================
// EXPLAIN: extending Exception makes this a CHECKED exception
public class InsufficientFundsException extends Exception {

    private final double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);                     // pass the message to Exception
        this.shortfall = shortfall;
    }

    public double getShortfall() { return shortfall; }
}
