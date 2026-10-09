import java.util.Scanner;

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else {
                students[i] = new ScholarStudent(name);
            }
        }
        double total = 0;
        for (Student student : students) {
            double fee = student.totalFee();
            total += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        if (this instanceof BusUser) {
            return tuition() + BusUser.TRANSPORT_FEE;
        }
        return tuition();
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class ScholarStudent extends Student implements BusUser {
    ScholarStudent(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }
}
