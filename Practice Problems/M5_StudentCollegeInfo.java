// M5. Student and College Information Management
// collegeName and studentCount are static: one shared copy for the whole
// class instead of a copy inside every Student object. printCollegeInfo()
// is static too, so it is called through the class name and touches no
// instance field.

public class M5_StudentCollegeInfo {
    public static void main(String[] args) {
        new Student("Ravi", 85);
        new Student("Anitha", 92);

        // called through the class name, not through either object
        Student.printCollegeInfo();
    }
}

class Student {
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    String name;
    int attendance;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}
