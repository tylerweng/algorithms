import java.util.*;

class Main {

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int buyIdx = 0;
        int maxProfit = 0;
        for (int sellIdx = 1; sellIdx < prices.length; sellIdx++) {
            int sellPrice = prices[sellIdx];
            int buyPrice = prices[buyIdx];
            int profit = sellPrice - buyPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (sellPrice < buyPrice) {
                buyIdx = sellIdx;
            }

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {}) == 0);
        System.out.println(maxProfit(new int[] {1}) == 0);
        System.out.println(maxProfit(new int[] {1, 2}) == 1);
        System.out.println(maxProfit(new int[] {2, 1}) == 0);
        System.out.println(maxProfit(new int[] {10, 7, 5, 8, 11, 9}) == 6);
        System.out.println(maxProfit(new int[] {10, 7, 5, 8, 11, 9, 3, 8}) == 6);
    }
}