import java.util.Scanner;

public class Problem3_DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Delivery[] deliveries = new Delivery[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);
            if (type.equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (type.equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = Double.parseDouble(parts[3]);
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }
        double total = 0;
        for (Delivery delivery : deliveries) {
            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", delivery.typeName(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double baseFee();

    abstract double perKg();

    abstract double perKm();

    double extraFee() {
        return 0;
    }

    abstract String typeName();

    double calculateFee() {
        return baseFee() + perKg() * weight + perKm() * distance + extraFee();
    }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double baseFee() {
        return 5;
    }

    double perKg() {
        return 0.50;
    }

    double perKm() {
        return 0.10;
    }

    String typeName() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double baseFee() {
        return 15;
    }

    double perKg() {
        return 1.00;
    }

    double perKm() {
        return 0.20;
    }

    String typeName() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double baseFee() {
        return 25;
    }

    double perKg() {
        return 2.00;
    }

    double perKm() {
        return 0.50;
    }

    double extraFee() {
        return customsFee;
    }

    String typeName() {
        return "INTERNATIONAL";
    }
}
