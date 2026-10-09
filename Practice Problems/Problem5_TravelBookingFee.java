import java.util.Scanner;

public class Problem5_TravelBookingFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        TravelBooking[] bookings = new TravelBooking[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String mode = parts[0];
            double distance = Double.parseDouble(parts[1]);
            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else {
                bookings[i] = new FlightBooking(distance);
            }
        }
        for (TravelBooking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.modeName(), booking.total());
        }
        sc.close();
    }
}

abstract class TravelBooking {
    static final double BOOKING_FEE = 50;

    protected double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    abstract String modeName();

    double total() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2 * distance;
    }

    String modeName() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) {
        super(distance);
    }

    double baseFare() {
        return 1.5 * distance;
    }

    String modeName() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + 4 * distance;
    }

    String modeName() {
        return "FLIGHT";
    }
}
