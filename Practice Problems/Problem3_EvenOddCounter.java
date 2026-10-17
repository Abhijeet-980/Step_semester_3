import java.util.Scanner;

public class Problem3_EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "");
        String[] tokens = line.trim().split("[,\\s]+");
        int even = 0;
        int odd = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            int number = Integer.parseInt(token);
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
