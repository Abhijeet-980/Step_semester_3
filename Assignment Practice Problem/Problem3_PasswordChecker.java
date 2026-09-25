public class Problem3_PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker weak = new PasswordChecker("abcd");
        PasswordChecker medium = new PasswordChecker("abcdefgh");
        PasswordChecker strong = new PasswordChecker("abcdefghij");

        System.out.println(weak.getStrength());
        System.out.println(medium.getStrength());
        System.out.println(strong.getStrength());
    }
}

class PasswordChecker {
    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        }
        if (length <= 9) {
            return "Medium";
        }
        return "Strong";
    }
}
