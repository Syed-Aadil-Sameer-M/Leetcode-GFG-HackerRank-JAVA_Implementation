import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solveQueries(int m, int n, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Track the current actual position of each row and column
        int[] rowMap = new int[m];
        int[] colMap = new int[n];
        
        // Initialize maps to their default index values
        for (int i = 0; i < m; i++) {
            rowMap[i] = i;
        }
        for (int j = 0; j < n; j++) {
            colMap[j] = j;
        }
        
        // Process each query
        for (int[] query : queries) {
            int type = query[0];
            int a = query[1];
            int b = query[2];
            
            if (type == 1) {
                // Swap row a and row b
                int temp = rowMap[a];
                rowMap[a] = rowMap[b];
                rowMap[b] = temp;
            } else if (type == 2) {
                // Swap column a and column b
                int temp = colMap[a];
                colMap[a] = colMap[b];
                colMap[b] = temp;
            } else if (type == 3) {
                // Fetch the mapped original coordinates
                long actualRow = rowMap[a];
                long actualCol = colMap[b];
                
                // Calculate value using row-major math
                // Using long prevents potential arithmetic overflow before casting/returning
                long value = actualRow * n + actualCol + 1;
                result.add((int) value);
            }
        }
        
        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna