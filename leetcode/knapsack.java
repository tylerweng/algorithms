class Solution {

    public static void main(String[] args) {
        // Note: Order of items doesn't matter, both the following
        // return correct answer;
        // int[] vals = {1, 3, 6, 5};
        // int[] weights = {1, 2, 4, 5};
        int [] vals = {3, 5, 1, 6};
        int [] weights = {2, 5, 1, 4};
        int capacity = 10;
        System.out.println(knapsack(vals, weights, capacity) == 12);
    }

    public static int knapsack(int[] vals, int[] weights, int capacity) {
        // 2d matrix where index of column represents total weight
        // and index of row represents index of item (same for val and weight)
        // where we only have access to items <= index of row
        // and values in matrix represent max value
        int[][] dp = new int[vals.length][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                // case capacity is zero along first column, max value is always 0
                if (j == 0) {
                    dp[i][j] = 0;
                // case only have access to first item, can't traverse up a row to check other items
                // and max value is only value of item or 0
                } else if (i == 0) {
                    if (weights[i] <= j) {
                        dp[i][j] = vals[i];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    // If you can use the item, take the max of this item's val plus the best val you can
                    // make w/o using the item with the remaining weight or the previous max value
                    if (weights[i] <= j) {
                        dp[i][j] = Math.max(
                                vals[i] + dp[i-1][j-weights[i]],
                                dp[i][j-1]
                        );
                    // If you can't use the item, go up a row and get the best value w/o it
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[vals.length - 1][capacity];
    }
}