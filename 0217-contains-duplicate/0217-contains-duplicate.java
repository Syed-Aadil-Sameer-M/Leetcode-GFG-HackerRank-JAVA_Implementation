import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Time Complexity: O(n^2) because of the double nested loops.
        // Space Complexity: O(1) extra space (ignoring the input array).
        // This solution works but can be optimized.
        // Hint: Use a HashSet to track seen numbers.
        // If a number is already in the set, you can return true immediately.
        // This reduces time to O(n) with O(n) extra space.
        int n = nums.length;
        boolean occur = false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<n; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
            else{
                occur = true;
                break;
            }
        }
        return occur;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna