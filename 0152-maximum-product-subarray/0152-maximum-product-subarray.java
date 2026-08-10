class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int tempMax = Math.max(num, 
                           Math.max(currMax * num, currMin * num));

            currMin = Math.min(num, 
                       Math.min(currMax * num, currMin * num));

            currMax = tempMax;

            maxProduct = Math.max(maxProduct, currMax);
        }
        
        /* Brute force
        for(int i = 0; i<n;i++){
            int prod = 1; 
            for(int j = i; j<n; j++){
                prod *= nums[j];
                if(maxproduct < prod){
                maxproduct = prod;
            }
            
            }
        }*/
        return maxProduct;
        
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna