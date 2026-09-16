// M3. Course Credit Management
// The 3-argument constructor chains to the 4-argument one via this(...)
// so the setup logic is written only once.

public class M3_CourseCreditManagement {
    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println("21CSC201J total credits: " + theoryCourse.totalCredits());
        System.out.println("21CSC205L total credits: " + labCourse.totalCredits());
    }
}

class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // theory-only course: chains to the full constructor with labCredits = 0
    Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }
}
