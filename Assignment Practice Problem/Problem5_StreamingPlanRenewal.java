import java.time.LocalDate;
import java.util.Scanner;

public class Problem5_StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        SubscriptionPlan[] subscribers = new SubscriptionPlan[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);
            if (type.equals("BASIC")) {
                subscribers[i] = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                subscribers[i] = new StandardPlan(name, startDate);
            } else {
                subscribers[i] = new PremiumPlan(name, startDate);
            }
        }
        for (SubscriptionPlan plan : subscribers) {
            System.out.println(plan.name + ": " + plan.renewalDate());
        }
        sc.close();
    }
}

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}
