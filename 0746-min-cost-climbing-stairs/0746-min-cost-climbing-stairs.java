import java.util.*;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n  = cost.length;
        int first = cost[0];
        int second = cost[1];
        int totalcost = 0;
        if(n<=2){
            return Math.min(first, second);
        }
        for(int i=2; i<n; i++){
            int cur = cost[i]+ Math.min(first, second);
            first = second;
            second = cur; 
        }
    return (Math.min(first, second));
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna