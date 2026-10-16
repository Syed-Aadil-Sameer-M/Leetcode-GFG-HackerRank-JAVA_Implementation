import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0; 
        int j = n-1;
        int max = 0;
        int area = 0;
        while (i<j){
            int temparea = (j-i) * Math.min(height[i],height[j]);
            if(max<temparea){
                max = temparea;
            }
            if(height[j]<height[i]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna