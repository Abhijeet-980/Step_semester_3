import java.util.Scanner;

public class Problem4_ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        PowerConnection[] connections = new PowerConnection[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else {
                connections[i] = new FactoryConnection(units);
            }
        }
        double total = 0;
        for (PowerConnection connection : connections) {
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", connection.typeName(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class PowerConnection {
    protected int units;

    PowerConnection(int units) {
        this.units = units;
    }

    abstract double bill();

    abstract String typeName();
}

class HomeConnection extends PowerConnection {
    HomeConnection(int units) {
        super(units);
    }

    double bill() {
        if (units <= 100) {
            return 5 * units;
        }
        return 5 * 100 + 7 * (units - 100);
    }

    String typeName() {
        return "HOME";
    }
}

class ShopConnection extends PowerConnection {
    ShopConnection(int units) {
        super(units);
    }

    double bill() {
        return 8 * units + 100;
    }

    String typeName() {
        return "SHOP";
    }
}

class FactoryConnection extends PowerConnection {
    FactoryConnection(int units) {
        super(units);
    }

    double bill() {
        double bill = 6 * units;
        return bill < 1000 ? 1000 : bill;
    }

    String typeName() {
        return "FACTORY";
    }
}
