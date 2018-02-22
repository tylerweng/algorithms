class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int val2 = 2, val3 = 3, val5 = 5;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(val2, Math.min(val3, val5));
            dp[i] = min;
            if (min == val2) {
                val2 = 2 * dp[++idx2];
            }
            if (min == val3) {
                val3 = 3 * dp[++idx3];
            }
            if (min == val5) {
                val5 = 5 * dp[++idx5];
            }
        }
        return dp[n-1];
    }
}