// Problem 1. The Piggy Bank
// savings is private and final ID is fixed at creation; the amount only
// changes through deposit() and withdraw(), never set directly.

public class Problem1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("ID: " + pb.getId());

        pb.deposit(100);
        System.out.println("After deposit 100: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw 30: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After withdraw 500: " + pb.getSavings());
    }
}

class PiggyBank {
    private final String id;
    private double savings;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdraw rejected: not enough savings");
            return;
        }
        savings -= amount;
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}
