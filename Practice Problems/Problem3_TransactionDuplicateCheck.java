import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem3_TransactionDuplicateCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        String[] transactionIds = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            transactionIds[i] = tokens[i];
        }
        System.out.println(hasDuplicate(transactionIds));
        sc.close();
    }

    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }
}
