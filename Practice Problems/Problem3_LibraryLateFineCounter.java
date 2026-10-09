import java.util.Scanner;

public class Problem3_LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        BorrowedItem[] items = new BorrowedItem[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);
            if (type.equals("BOOK")) {
                items[i] = new BookItem(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new DvdItem(title, daysLate);
            } else {
                items[i] = new MagazineItem(title, daysLate);
            }
        }
        double total = 0;
        for (BorrowedItem item : items) {
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}

abstract class BorrowedItem {
    protected String title;
    protected int daysLate;

    BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class BookItem extends BorrowedItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return 2 * daysLate;
    }
}

class DvdItem extends BorrowedItem {
    DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        double fine = 5 * daysLate;
        return fine > 50 ? 50 : fine;
    }
}

class MagazineItem extends BorrowedItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return 1 * daysLate;
    }
}
