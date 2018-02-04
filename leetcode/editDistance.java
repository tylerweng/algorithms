public class Main {
    public int editDistance(String word1, String word2) {
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for(int i = 0; i <= word2.length(); i++) {
            for(int j = 0; j <= word1.length(); j++) {
                if(i == 0 && j == 0) dp[i][j] = 0; // no strings given
                else if(i == 0 && j != 0) {
                    dp[i][j] = j; // word2 is empty
                } else if(i != 0 && j == 0) {
                    dp[i][j] = i; // word1 is empty
                } else if(word2.charAt(i-1) != word1.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                }else {
                    dp[i][j] = dp[i-1][j-1]; // same characters just carry over previous chars from both
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}