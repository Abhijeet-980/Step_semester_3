import java.util.Scanner;

public class Problem1_TheHeightLineUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        int[] heights = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            heights[i] = Integer.parseInt(tokens[i]);
        }
        lineUp(heights);
        sc.close();
    }

    static void lineUp(int[] heights) {
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + arrayToString(heights));
            if (!swapped) {
                break;
            }
        }
    }

    static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
