import java.util.Scanner;

public class Problem1_PaymentFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Payment[] payments = new Payment[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else {
                payments[i] = new BankTransferPayment(amount);
            }
        }
        double total = 0;
        for (Payment payment : payments) {
            double adjusted = payment.adjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f%n", payment.typeName(), adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double feeRate();

    abstract String typeName();

    double adjustedAmount() {
        return amount * (1 + feeRate());
    }
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double feeRate() {
        return 0.02;
    }

    String typeName() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double feeRate() {
        return 0.01;
    }

    String typeName() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double feeRate() {
        return 0.0;
    }

    String typeName() {
        return "BANKTRANSFER";
    }
}
