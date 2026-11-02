import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem4_EmployeeIdLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] records = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            records[i][0] = parts[0];
            records[i][1] = parts[1];
        }
        Map<String, String> lookup = buildLookup(records);
        List<String> queries = new ArrayList<>();
        while (sc.hasNextLine()) {
            String query = sc.nextLine().trim();
            if (!query.isEmpty()) {
                queries.add(query);
            }
        }
        for (String query : queries) {
            System.out.println("\"" + getDepartment(lookup, query) + "\"");
        }
        sc.close();
    }

    static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    static String getDepartment(Map<String, String> lookup, String employeeId) {
        String department = lookup.get(employeeId);
        return department == null ? "Unknown" : department;
    }
}
