class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        // 2D array to store lengths of longest common subsequences
        int[][] dp = new int[m + 1][n + 1];
        
        // dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take max of excluding one character
                }
            }
        }
        
        // The length of the longest common subsequence is in dp[m][n]
        return dp[m][n];
    }
}
