// ============================================================
// Lab 11 Mini-Project
// File: LibBook.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class LibBook extends LibraryItem {

    private final String author;
    private final int pages;

    public LibBook(String id, String title, String author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public int loanPeriodDays() { return 14; }

    public String getAuthor() { return author; }
    public int getPages()     { return pages; }

    @Override
    public String toString() {
        return super.toString() + " [Book by " + author + ", " + pages + " pages]";
    }
}
