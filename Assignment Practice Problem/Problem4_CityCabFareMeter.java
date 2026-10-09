import java.util.Scanner;

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Cab[] cabs = new Cab[n];
        String[] times = new String[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            times[i] = parts[2];
            if (type.equals("MINI")) {
                cabs[i] = new MiniCab(km);
            } else if (type.equals("SEDAN")) {
                cabs[i] = new SedanCab(km);
            } else {
                cabs[i] = new SuvCab(km);
            }
        }
        double total = 0;
        for (int i = 0; i < cabs.length; i++) {
            if (times[i].equals("NIGHT") && !(cabs[i] instanceof NightService)) {
                System.out.printf("%s: night service not available%n", cabs[i].cabName());
            } else {
                double fare = cabs[i].fare();
                if (times[i].equals("NIGHT")) {
                    fare = fare * 1.2;
                }
                total += fare;
                System.out.printf("%s: %.2f%n", cabs[i].cabName(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

interface NightService {
}

abstract class Cab {
    protected double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double ratePerKm();

    abstract String cabName();

    double fare() {
        double fare = km * ratePerKm();
        return fare < 100 ? 100 : fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double ratePerKm() {
        return 10;
    }

    String cabName() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double ratePerKm() {
        return 14;
    }

    String cabName() {
        return "SEDAN";
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double km) {
        super(km);
    }

    double ratePerKm() {
        return 18;
    }

    String cabName() {
        return "SUV";
    }
}
