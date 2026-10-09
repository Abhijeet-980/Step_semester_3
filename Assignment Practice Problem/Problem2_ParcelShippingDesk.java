import java.util.Scanner;

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Parcel[] parcels = new Parcel[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double declaredValue = Double.parseDouble(parts[2]);
            if (type.equals("STANDARD")) {
                parcels[i] = new StandardParcel(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, declaredValue);
            } else {
                parcels[i] = new FragileParcel(weight, declaredValue);
            }
        }
        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.charge();
            double insurance = 0;
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).insurance();
            }
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.typeName(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}

interface Insurable {
    double insurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double charge();

    abstract String typeName();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double charge() {
        return 40 + 10 * weight;
    }

    String typeName() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return 0.02 * declaredValue;
    }

    String typeName() {
        return "EXPRESS";
    }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double charge() {
        return super.charge() + 50;
    }

    public double insurance() {
        return 0.02 * declaredValue;
    }

    String typeName() {
        return "FRAGILE";
    }
}
