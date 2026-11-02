class Solution {
    public int missingNumber(int[] nums) {
        int n  = nums.length;
        int sum = (n*(n+1))/2;
        int temp = 0;
        for(int i =0; i<n; i++){
            temp +=nums[i];
        }
        int dif = sum - temp;
        return dif;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna