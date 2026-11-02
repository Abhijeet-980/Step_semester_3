import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2_WarehouseBinGridScan {
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
        int[] summary = warehouseSummary(grid);
        System.out.println("total = " + summary[0] + ", maxCoordinate = (" + summary[1] + ", " + summary[2] + ")");
        sc.close();
    }

    static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxRow = 0;
        int maxCol = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxValue) {
                    maxValue = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{total, maxRow, maxCol};
    }
}
