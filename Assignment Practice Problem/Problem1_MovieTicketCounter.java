import java.util.Scanner;

public class Problem1_MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Ticket[] bookings = new Ticket[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String seat = parts[0];
            int count = Integer.parseInt(parts[1]);
            if (seat.equals("REGULAR")) {
                bookings[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                bookings[i] = new PremiumTicket(count);
            } else {
                bookings[i] = new ReclinerTicket(count);
            }
        }
        double total = 0;
        for (Ticket booking : bookings) {
            double amount = booking.amount();
            total += amount;
            System.out.printf("%s: %.2f%n", booking.seatName(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;

    protected int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double pricePerTicket();

    abstract String seatName();

    double amount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 150;
    }

    String seatName() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 250;
    }

    String seatName() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double pricePerTicket() {
        return 400;
    }

    String seatName() {
        return "RECLINER";
    }
}
