class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int total = numBottles;
        while (numBottles >= numExchange) {
            int exchange = numBottles / numExchange; 
            total += exchange;
            numBottles = exchange + (numBottles % numExchange); 
        }
        return total;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna