class Solution {
    public int maxArea(int[] height) {
        // Two-pointer approach: start with the widest container and shrink inward,
        // always moving the pointer at the shorter line to potentially find a taller one.
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int currHeight = Math.min(height[left], height[right]);
            int area = width * currHeight;
            if (area > maxArea) {
                maxArea = area;
            }
            // Move the pointer at the shorter line inward.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna