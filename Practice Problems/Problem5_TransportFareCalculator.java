import java.util.Scanner;

public class Problem5_TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Transport[] journeys = new Transport[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            if (type.equals("BUS")) {
                journeys[i] = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                journeys[i] = new Train(distance);
            } else {
                double peakHourFactor = Double.parseDouble(parts[2]);
                journeys[i] = new Metro(distance, peakHourFactor);
            }
        }
        double total = 0;
        for (Transport journey : journeys) {
            double fare = journey.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", journey.typeName(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    abstract double perKm();

    abstract String typeName();

    double calculateFare() {
        return baseFare() + perKm() * distance;
    }
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2;
    }

    double perKm() {
        return 0.10;
    }

    String typeName() {
        return "BUS";
    }

    double calculateFare() {
        double fare = super.calculateFare();
        return fare > 10 ? 10 : fare;
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double baseFare() {
        return 3;
    }

    double perKm() {
        return 0.15;
    }

    String typeName() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double baseFare() {
        return 1.50;
    }

    double perKm() {
        return 0.20;
    }

    String typeName() {
        return "METRO";
    }

    double calculateFare() {
        return super.calculateFare() * peakHourFactor;
    }
}
