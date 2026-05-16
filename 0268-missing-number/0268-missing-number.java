class Solution {
    public int missingNumber(int[] nums) {
        // Use XOR to find the missing number in O(n) time and O(1) space.
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i];
        }
        xor ^= n; // include the last index
        return xor;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna