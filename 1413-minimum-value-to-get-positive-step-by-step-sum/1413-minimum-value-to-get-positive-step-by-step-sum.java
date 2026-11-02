class Solution {
    public int minStartValue(int[] nums) {

        int sum = 0;
        int minSum = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum);
        }

        return 1 - minSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna