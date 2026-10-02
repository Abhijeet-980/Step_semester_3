import java.util.Scanner;

public class Problem3_HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        HostelRoom[] rooms = new HostelRoom[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            if (type.equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = Integer.parseInt(parts[2]);
                rooms[i] = new SharedRoom(units, occupants);
            } else {
                rooms[i] = new AcRoom(units);
            }
        }
        double total = 0;
        for (HostelRoom room : rooms) {
            double bill = room.billAmount();
            total += bill;
            System.out.printf("%s: %.2f%n", room.typeName(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class HostelRoom {
    protected int units;

    HostelRoom(int units) {
        this.units = units;
    }

    abstract double billAmount();

    abstract String typeName();
}

class SingleRoom extends HostelRoom {
    SingleRoom(int units) {
        super(units);
    }

    double billAmount() {
        return 8 * units;
    }

    String typeName() {
        return "SINGLE";
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double billAmount() {
        return 6.0 * units / occupants;
    }

    String typeName() {
        return "SHARED";
    }
}

class AcRoom extends HostelRoom {
    AcRoom(int units) {
        super(units);
    }

    double billAmount() {
        return 10 * units + 200;
    }

    String typeName() {
        return "AC";
    }
}
