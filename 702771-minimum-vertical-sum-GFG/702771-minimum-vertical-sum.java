import java.util.ArrayList;

class Solution {
    public int minimum_vertical_sum(ArrayList<ArrayList<Integer>> arr, int n) {
        // Step 1: Find the maximum number of columns across all rows
        int maxCols = 0;
        for (ArrayList<Integer> row : arr) {
            if (row.size() > maxCols) {
                maxCols = row.size();
            }
        }
        
        // Step 2: Create an array to store the sum of each vertical column
        int[] verticalSums = new int[maxCols];
        
        // Step 3: Accumulate sums column-wise by iterating through each row
        for (ArrayList<Integer> row : arr) {
            for (int j = 0; j < row.size(); j++) {
                verticalSums[j] += row.get(j);
            }
        }
        
        // Step 4: Find the minimum sum from our vertical sums array
        int minSum = Integer.MAX_VALUE;
        for (int sum : verticalSums) {
            if (sum < minSum) {
                minSum = sum;
            }
        }
        
        return minSum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna