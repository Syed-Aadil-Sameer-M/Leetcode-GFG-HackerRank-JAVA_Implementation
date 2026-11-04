class Solution {
    public int climbStairs(int n) {
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1);
       return f(n,dp);
    }
    public int f(int n, int[] dp){
        if(n<=2){
            return n;
        } 
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = f(n-1, dp) + f(n-2,dp);
        return dp[n];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna