class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            long rightSum = total - leftSum - nums[i];
            result[i] = (int) Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna