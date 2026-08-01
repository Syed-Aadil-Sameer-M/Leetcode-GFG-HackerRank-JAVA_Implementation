class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int cur = nums[0];
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        if(n>1){
            for(int i=1; i<n; i++){
                cur = Math.max(nums[i], nums[i]+cur);
                sum = Math.max(sum, cur);
            }
            return sum;
        }
        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna