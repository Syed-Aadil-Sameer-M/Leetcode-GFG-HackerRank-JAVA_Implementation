class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minbuy = prices[0];
        int profit = 0;
        for (int i = 1; i<n; i++){
            minbuy = Math.min(minbuy, prices[i]);
            profit = Math.max(profit, prices[i]-minbuy);
        }
        return profit;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna