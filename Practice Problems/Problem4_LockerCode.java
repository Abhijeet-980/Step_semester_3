// Problem 4. The Locker Code
// write-only: the code can be changed (with the current code entered
// correctly) but there is no getter that ever reads it back.

public class Problem4_LockerCode {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("Locker number: " + l.getLockerNumber());

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");

        l.changeCode("5678", "4321");
    }
}

class Locker {
    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    void changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            System.out.println("Rejected: wrong current code, code unchanged");
            return;
        }
        code = newCode;
        System.out.println("Success: code changed");
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}
