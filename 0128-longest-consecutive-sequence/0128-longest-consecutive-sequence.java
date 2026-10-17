import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxcount=1;
        int count =1;
        int i=0;
        while(i<n-1){
            if(nums[i+1]-nums[i]==1){
                count++;
                i++;
                continue;
            }
            else if(nums[i+1]==nums[i]){
                i++;
                continue;
            }
            else{
                if(maxcount<count){
                    maxcount=count;
                }
                count=1;
                i++;
            }
        }
        if(maxcount<count){
            maxcount=count;
        }
        if(n==0){
            return 0;
        }
        else{
        return maxcount;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna