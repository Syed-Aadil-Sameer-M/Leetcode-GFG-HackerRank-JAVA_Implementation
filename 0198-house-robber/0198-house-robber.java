class Solution {
    public int rob(int[] nums) {

        int prev2 = 0; // Maximum money up to house i-2
        int prev1 = 0; // Maximum money up to house i-1

        for (int num : nums) {

            int curr = Math.max(prev1, prev2 + num);
            // Skip current house OR rob current + previous i-2

            prev2 = prev1; // Move previous state
            prev1 = curr;  // Update maximum money
        }

        return prev1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna