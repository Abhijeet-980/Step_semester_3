import java.util.Scanner;

public class Problem2_WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Staff[] staffMembers = new Staff[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            if (type.equals("FULLTIME")) {
                staffMembers[i] = new FullTimeStaff(name, Double.parseDouble(parts[2]));
            } else if (type.equals("HOURLY")) {
                staffMembers[i] = new HourlyStaff(name, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            } else {
                staffMembers[i] = new InternStaff(name, Double.parseDouble(parts[2]));
            }
        }
        double total = 0;
        for (Staff member : staffMembers) {
            double pay = member.pay();
            total += pay;
            System.out.printf("%s: %.2f%n", member.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double pay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}
