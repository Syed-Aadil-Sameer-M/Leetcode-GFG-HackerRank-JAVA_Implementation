class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i =0; i<n; i++){
            result = result^nums[i];
        }
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna