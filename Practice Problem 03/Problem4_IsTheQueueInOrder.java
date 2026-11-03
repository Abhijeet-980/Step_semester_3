import java.util.Scanner;

public class Problem4_IsTheQueueInOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        int[] queue = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            queue[i] = Integer.parseInt(tokens[i]);
        }
        System.out.println(firstBreak(queue));
        sc.close();
    }

    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }
}
