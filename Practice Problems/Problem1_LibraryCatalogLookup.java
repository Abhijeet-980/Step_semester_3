import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1_LibraryCatalogLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] catalog = new String[n][2];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            catalog[i][0] = line.substring(0, space);
            catalog[i][1] = line.substring(space + 1).trim();
        }
        List<String> queries = new ArrayList<>();
        while (sc.hasNextLine()) {
            String query = sc.nextLine().trim();
            if (!query.isEmpty()) {
                queries.add(query);
            }
        }
        for (String query : queries) {
            System.out.println("\"" + findBook(catalog, query) + "\"");
        }
        sc.close();
    }

    static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = catalog[mid][0].compareTo(targetIsbn);
            if (comparison == 0) {
                return catalog[mid][1];
            }
            if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }
}
