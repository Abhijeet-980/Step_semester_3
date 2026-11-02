import java.util.Scanner;

public class Problem6_BestSingleTradeProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]]", "").trim();
        String[] tokens = line.split("[,\\s]+");
        int[] prices = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            prices[i] = Integer.parseInt(tokens[i]);
        }
        System.out.println(maxProfit(prices));
        sc.close();
    }

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int bestProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > bestProfit) {
                bestProfit = profit;
            }
        }
        return bestProfit;
    }
}
