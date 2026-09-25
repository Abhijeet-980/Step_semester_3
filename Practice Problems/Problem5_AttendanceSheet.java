// Problem 5. The Attendance Sheet
// names stay in a private array; only the count and a yes/no lookup are
// exposed. Duplicate marks are ignored.

public class Problem5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}

class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (count >= presentStudents.length) {
            System.out.println("Rejected: attendance sheet is full");
            return;
        }
        presentStudents[count] = name;
        count++;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}
