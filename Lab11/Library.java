// ============================================================
// Lab 11 Mini-Project
// File: Library.java
// Student: Ronald Murape (H250475V)
// ============================================================
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {

    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addItem(LibraryItem item)       { items.put(item.getId(), item); }
    public void registerMember(Member m)        { members.put(m.getId(), m); }

    public LibraryItem getItem(String id)       { return items.get(id); }
    public Member getMember(String id)          { return members.get(id); }
    public List<LibraryItem> allItems()        { return new ArrayList<>(items.values()); }
    public List<Member> allMembers()           { return new ArrayList<>(members.values()); }
    public List<Loan> allLoans()               { return new ArrayList<>(loans); }

    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Member m = members.get(memberId);
        if (m == null) throw new IllegalArgumentException("Unknown member: " + memberId);
        LibraryItem item = items.get(itemId);
        if (item == null) throw new IllegalArgumentException("Unknown item: " + itemId);
        if (!item.isAvailable()) throw new ItemNotAvailableException(item.getTitle() + " is not available");
        if (m.hasReachedLimit()) throw new MemberLimitExceededException(m.getName() + " already has 3 loans");

        item.setAvailable(false);
        Loan loan = new Loan(m, item);
        loans.add(loan);
        m.addLoan(loan);
    }

    public void giveBack(String memberId, String itemId) {
        Member m = members.get(memberId);
        LibraryItem item = items.get(itemId);
        if (m == null || item == null) throw new IllegalArgumentException("Unknown member or item");
        Loan toRemove = null;
        for (Loan l : loans) {
            if (l.getMember() == m && l.getItem() == item) { toRemove = l; break; }
        }
        if (toRemove != null) {
            loans.remove(toRemove);
            m.removeLoan(toRemove);
            item.setAvailable(true);
        } else {
            throw new IllegalArgumentException("No active loan found for that item/member");
        }
    }

    public List<LibraryItem> searchByTitle(String text) {
        String needle = text.toLowerCase();
        return items.values().stream()
                .filter(i -> i.getTitle().toLowerCase().contains(needle))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .collect(Collectors.toList());
    }

    public List<Loan> overdueLoans() {
        return loans.stream().filter(Loan::isOverdue).collect(Collectors.toList());
    }

    // ---------- persistence ----------
    public void saveTo(Path dir) throws IOException {
        if (!Files.exists(dir)) Files.createDirectories(dir);

        List<String> itemLines = new ArrayList<>();
        for (LibraryItem it : items.values()) {
            if (it instanceof LibBook b) {
                itemLines.add("BOOK," + b.getId() + "," + b.getTitle() + "," + b.getAuthor() + "," + b.getPages());
            } else if (it instanceof Dvd d) {
                itemLines.add("DVD," + d.getId() + "," + d.getTitle() + "," + d.getDurationMinutes());
            }
        }
        Files.write(dir.resolve("items.csv"), itemLines);

        List<String> memberLines = new ArrayList<>();
        for (Member m : members.values()) memberLines.add(m.getId() + "," + m.getName());
        Files.write(dir.resolve("members.csv"), memberLines);

        List<String> loanLines = new ArrayList<>();
        for (Loan l : loans) loanLines.add(l.getMember().getId() + "," + l.getItem().getId() + "," + l.getDueDate());
        Files.write(dir.resolve("loans.csv"), loanLines);
    }

    public void loadFrom(Path dir) throws IOException {
        Path itemsFile = dir.resolve("items.csv");
        if (Files.exists(itemsFile)) {
            for (String line : Files.readAllLines(itemsFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                if (p[0].equals("BOOK")) {
                    addItem(new LibBook(p[1], p[2], p[3], Integer.parseInt(p[4])));
                } else if (p[0].equals("DVD")) {
                    addItem(new Dvd(p[1], p[2], Integer.parseInt(p[3])));
                }
            }
        }

        Path membersFile = dir.resolve("members.csv");
        if (Files.exists(membersFile)) {
            for (String line : Files.readAllLines(membersFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                registerMember(new Member(p[0], p[1]));
            }
        }

        Path loansFile = dir.resolve("loans.csv");
        if (Files.exists(loansFile)) {
            for (String line : Files.readAllLines(loansFile)) {
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                Member m = members.get(p[0]);
                LibraryItem it = items.get(p[1]);
                if (m != null && it != null) {
                    it.setAvailable(false);
                    Loan loan = new Loan(m, it, LocalDate.parse(p[2]));
                    loans.add(loan);
                    m.addLoan(loan);
                }
            }
        }
    }

    public static void seedData(Library lib) {
        lib.addItem(new LibBook("B1", "Clean Code", "Robert Martin", 464));
        lib.addItem(new LibBook("B2", "Effective Java", "Joshua Bloch", 412));
        lib.addItem(new Dvd("D1", "The Matrix", 136));
        lib.registerMember(new Member("M1", "Tendai"));
        lib.registerMember(new Member("M2", "Rudo"));
    }

    public static void main(String[] args) {
        // demo
        Library lib = new Library();
        seedData(lib);
        try {
            lib.borrow("M1", "B1");
            System.out.println("Borrowed. Overdue: " + lib.overdueLoans().size());
            System.out.println("Search 'code': " + lib.searchByTitle("code"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
