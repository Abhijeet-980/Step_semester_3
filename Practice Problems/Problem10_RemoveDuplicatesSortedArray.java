import java.util.Scanner;

public class Problem10_RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        int length = removeDuplicates(nums);
        System.out.println("length = " + length);
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            result.append(nums[i]);
            if (i < length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        System.out.println("nums[0.." + (length - 1) + "] = " + result);
        sc.close();
    }

    static int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}
