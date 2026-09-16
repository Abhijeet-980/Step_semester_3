// M2. Hostel Mess Wallet Management
// balance is private and can never be set directly from outside;
// it only changes through the guarded topUp() and deduct() methods.

public class M2_HostelMessWallet {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}

class MessWallet {
    private double balance;

    MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: opening balance cannot be negative, starting at 0");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
    }

    void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }
}
