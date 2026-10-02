import java.util.Scanner;

public class Problem2_ParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ParkedVehicle[] vehicles = new ParkedVehicle[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            if (type.equals("BIKE")) {
                vehicles[i] = new Bike(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new Car(hours);
            } else {
                vehicles[i] = new Truck(hours);
            }
        }
        double total = 0;
        for (ParkedVehicle vehicle : vehicles) {
            double charge = vehicle.charge();
            total += charge;
            System.out.printf("%s: %.2f%n", vehicle.typeName(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class ParkedVehicle {
    protected int hours;

    ParkedVehicle(int hours) {
        this.hours = hours;
    }

    abstract double charge();

    abstract String typeName();
}

class Bike extends ParkedVehicle {
    Bike(int hours) {
        super(hours);
    }

    double charge() {
        return 10 * hours;
    }

    String typeName() {
        return "BIKE";
    }
}

class Car extends ParkedVehicle {
    Car(int hours) {
        super(hours);
    }

    double charge() {
        return 30 + 20 * (hours - 1);
    }

    String typeName() {
        return "CAR";
    }
}

class Truck extends ParkedVehicle {
    Truck(int hours) {
        super(hours);
    }

    double charge() {
        double charge = 50 * hours;
        return charge < 100 ? 100 : charge;
    }

    String typeName() {
        return "TRUCK";
    }
}
