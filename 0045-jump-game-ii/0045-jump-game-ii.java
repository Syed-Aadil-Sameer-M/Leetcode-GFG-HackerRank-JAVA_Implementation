class Solution {
    public int jump(int[] nums) {
        int jumps = 0;         // Number of jumps made
        int currentEnd = 0;   // The farthest index that can be reached with the current number of jumps
        int farthest = 0;      // The farthest index that can be reached with the next jump

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point that can be reached from current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we have come to the end of the current jump
            if (i == currentEnd) {
                jumps++;            // We need to make a jump
                currentEnd = farthest; // Move to the farthest point we can reach
            }
        }

        return jumps; // Return the total number of jumps made
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna