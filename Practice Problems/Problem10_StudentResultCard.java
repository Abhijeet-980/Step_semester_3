import java.util.Scanner;

public class Problem10_StudentResultCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }
        Student student = new Student(name, marks);
        double average = student.average();
        System.out.println(student.name.toUpperCase() + ": Average " + String.format("%.1f", average) + ", Grade " + student.grade());
        sc.close();
    }
}

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum / 3.0;
    }

    char grade() {
        double average = average();
        if (average >= 90) {
            return 'A';
        } else if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        }
        return 'F';
    }
}
