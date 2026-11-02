import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem8_SpiralOrderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> rows = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] tokens = line.split("[,\\s]+");
            int[] row = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                row[i] = Integer.parseInt(tokens[i]);
            }
            rows.add(row);
        }
        int[][] grid = rows.toArray(new int[0][]);
        List<Integer> spiral = spiralOrder(grid);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < spiral.size(); i++) {
            result.append(spiral.get(i));
            if (i < spiral.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        System.out.println(result);
        sc.close();
    }

    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(grid[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(grid[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(grid[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(grid[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
