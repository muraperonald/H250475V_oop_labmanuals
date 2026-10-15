// ============================================================
// Lab 11 Mini-Project: Library Management System
// File: LibraryItem.java
// Student: Ronald Murape (H250475V)
// ============================================================
public abstract class LibraryItem {

    private final String id;
    private final String title;
    private boolean available = true;

    protected LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract int loanPeriodDays();

    public String getId()       { return id; }
    public String getTitle()    { return title; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return id + " - " + title + " (" + (available ? "available" : "on loan") + ")";
    }
}
