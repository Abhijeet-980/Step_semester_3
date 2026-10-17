import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem10_BusiestBusRow {
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
        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
        sc.close();
    }

    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }
}
