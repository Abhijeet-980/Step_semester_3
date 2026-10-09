import java.util.Scanner;

public class Problem5_ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            saverRequested[i] = parts.length > 2 && parts[2].equals("SAVER");
            if (type.equals("FRIDGE")) {
                appliances[i] = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliances[i] = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliances[i] = new Television(hours);
            } else {
                appliances[i] = new WashingMachine(hours);
            }
        }
        double total = 0;
        for (int i = 0; i < appliances.length; i++) {
            if (saverRequested[i] && !(appliances[i] instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported%n", appliances[i].applianceName());
            } else {
                double units = appliances[i].units();
                if (saverRequested[i]) {
                    units = units * 0.75;
                }
                double cost = units * 8;
                total += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliances[i].applianceName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}

interface SaverMode {
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double powerRating();

    abstract String applianceName();

    double units() {
        return powerRating() * hours / 1000;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double powerRating() {
        return 150;
    }

    String applianceName() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double powerRating() {
        return 1500;
    }

    String applianceName() {
        return "AC";
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double powerRating() {
        return 100;
    }

    String applianceName() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double powerRating() {
        return 500;
    }

    String applianceName() {
        return "WASHER";
    }
}
