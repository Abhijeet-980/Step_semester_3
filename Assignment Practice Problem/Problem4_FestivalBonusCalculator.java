import java.util.Scanner;

public class Problem4_FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        BonusEmployee[] employees = new BonusEmployee[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);
            if (type.equals("FULLTIME")) {
                employees[i] = new FullTimeEmployee(name, salary);
            } else if (type.equals("PARTTIME")) {
                employees[i] = new PartTimeEmployee(name, salary);
            } else {
                employees[i] = new InternEmployee(name, salary);
            }
        }
        double total = 0;
        for (BonusEmployee employee : employees) {
            double bonus = employee.bonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", employee.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}

abstract class BonusEmployee {
    protected String name;
    protected double salary;

    BonusEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double bonus();
}

class FullTimeEmployee extends BonusEmployee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends BonusEmployee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends BonusEmployee {
    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return 2000;
    }
}
