// ============================================================
// Lab 11 Mini-Project
// File: LibraryApp.java  (menu-driven application)
// Student: Ronald Murape (H250475V)
// ============================================================
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class LibraryApp {

    private static final Path DATA_DIR = Paths.get("library-data");

    public static void main(String[] args) throws Exception {
        Library lib = new Library();
        java.nio.file.Files.createDirectories(DATA_DIR);
        lib.loadFrom(DATA_DIR);

        // seed only if empty (first run)
        if (lib.allItems().isEmpty() && lib.allMembers().isEmpty()) {
            Library.seedData(lib);
            lib.saveTo(DATA_DIR);
        }

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add item");
            System.out.println("2. Register member");
            System.out.println("3. Borrow item");
            System.out.println("4. Return item");
            System.out.println("5. List overdue items");
            System.out.println("6. Search by title");
            System.out.println("7. List all items");
            System.out.println("8. Save & Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> addItem(lib, sc);
                    case "2" -> registerMember(lib, sc);
                    case "3" -> borrow(lib, sc);
                    case "4" -> giveBack(lib, sc);
                    case "5" -> listOverdue(lib);
                    case "6" -> search(lib, sc);
                    case "7" -> lib.allItems().forEach(System.out::println);
                    case "8" -> { lib.saveTo(DATA_DIR); running = false; System.out.println("Saved. Goodbye."); }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void addItem(Library lib, Scanner sc) {
        System.out.print("Type (book/dvd): ");
        String type = sc.nextLine().trim().toLowerCase();
        System.out.print("Id: "); String id = sc.nextLine().trim();
        System.out.print("Title: "); String title = sc.nextLine().trim();
        if (type.equals("book")) {
            System.out.print("Author: "); String author = sc.nextLine().trim();
            System.out.print("Pages: "); int pages = Integer.parseInt(sc.nextLine().trim());
            lib.addItem(new LibBook(id, title, author, pages));
        } else {
            System.out.print("Duration (min): "); int dur = Integer.parseInt(sc.nextLine().trim());
            lib.addItem(new Dvd(id, title, dur));
        }
        System.out.println("Item added.");
    }

    private static void registerMember(Library lib, Scanner sc) {
        System.out.print("Member id: "); String id = sc.nextLine().trim();
        System.out.print("Name: "); String name = sc.nextLine().trim();
        lib.registerMember(new Member(id, name));
        System.out.println("Member registered.");
    }

    private static void borrow(Library lib, Scanner sc) throws Exception {
        System.out.print("Member id: "); String m = sc.nextLine().trim();
        System.out.print("Item id: "); String i = sc.nextLine().trim();
        lib.borrow(m, i);
        System.out.println("Borrowed successfully.");
    }

    private static void giveBack(Library lib, Scanner sc) {
        System.out.print("Member id: "); String m = sc.nextLine().trim();
        System.out.print("Item id: "); String i = sc.nextLine().trim();
        lib.giveBack(m, i);
        System.out.println("Returned successfully.");
    }

    private static void listOverdue(Library lib) {
        List<Loan> overdue = lib.overdueLoans();
        if (overdue.isEmpty()) System.out.println("No overdue items.");
        else overdue.forEach(System.out::println);
    }

    private static void search(Library lib, Scanner sc) {
        System.out.print("Search text: "); String text = sc.nextLine().trim();
        List<LibraryItem> results = lib.searchByTitle(text);
        if (results.isEmpty()) System.out.println("No matches.");
        else results.forEach(System.out::println);
    }
}
