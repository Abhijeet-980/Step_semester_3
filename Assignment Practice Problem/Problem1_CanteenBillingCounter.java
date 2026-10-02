import java.util.Scanner;

public class Problem1_CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Customer[] bills = new Customer[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            if (type.equals("STUDENT")) {
                bills[i] = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                bills[i] = new StaffCustomer(amount);
            } else {
                bills[i] = new GuestCustomer(amount);
            }
        }
        double total = 0;
        for (Customer bill : bills) {
            double finalAmount = bill.finalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", bill.typeName(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double finalAmount();

    abstract String typeName();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super(amount);
    }

    double finalAmount() {
        return amount * 0.90;
    }

    String typeName() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super(amount);
    }

    double finalAmount() {
        return amount * 0.95;
    }

    String typeName() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super(amount);
    }

    double finalAmount() {
        return amount + 10;
    }

    String typeName() {
        return "GUEST";
    }
}
