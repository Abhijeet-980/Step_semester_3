import java.time.LocalDate;
import java.util.Scanner;

public class Problem2_LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(sc.nextLine().trim());
        LibraryItem[] items = new LibraryItem[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.split("\\s+")[0];
            String title = line.substring(type.length()).trim();
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }
            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new Dvd(title);
            } else {
                items[i] = new Magazine(title);
            }
        }
        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate(today));
        }
        sc.close();
    }
}

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int loanPeriod();

    LocalDate dueDate(LocalDate borrowedOn) {
        return borrowedOn.plusDays(loanPeriod());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int loanPeriod() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title) {
        super(title);
    }

    int loanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int loanPeriod() {
        return 3;
    }
}
