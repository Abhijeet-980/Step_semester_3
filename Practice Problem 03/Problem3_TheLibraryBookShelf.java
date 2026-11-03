import java.util.Scanner;

public class Problem3_TheLibraryBookShelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        int[] books = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            books[i] = Integer.parseInt(tokens[i]);
        }
        shelf(books);
        sc.close();
    }

    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int current = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > current) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = current;
            System.out.println("After placing " + current + ": " + arrayToString(books));
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
