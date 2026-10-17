import java.util.Scanner;

public class Problem8_DutyRosterRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        String[] names = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            names[i] = tokens[i];
        }
        int k = Integer.parseInt(sc.next().trim());
        String[] rotated = rotateRoster(names, k);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < rotated.length; i++) {
            result.append(rotated[i]);
            if (i < rotated.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        System.out.println(result);
        sc.close();
    }

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n;
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }
}
