// ============================================================
// Lab 11 Mini-Project
// File: Dvd.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class Dvd extends LibraryItem {

    private final int durationMinutes;

    public Dvd(String id, String title, int durationMinutes) {
        super(id, title);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public int loanPeriodDays() { return 7; }

    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public String toString() {
        return super.toString() + " [DVD, " + durationMinutes + " min]";
    }
}
