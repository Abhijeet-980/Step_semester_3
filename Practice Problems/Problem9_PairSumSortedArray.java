import java.util.Scanner;

public class Problem9_PairSumSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        int target = Integer.parseInt(sc.next().trim());
        int[] pair = pairSumSorted(nums, target);
        if (pair == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
        sc.close();
    }

    static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
