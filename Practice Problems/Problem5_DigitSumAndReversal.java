import java.util.Scanner;

public class Problem5_DigitSumAndReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0;
        int reverse = 0;
        int remaining = number;
        while (remaining > 0) {
            int digit = remaining % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            remaining /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
        sc.close();
    }
}
