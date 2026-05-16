class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRow = false;
        boolean firstCol = false;
        
        // Check first row
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        
        // Check first column
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        
        // Use first row and column as markers
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Set matrix cells to 0
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Set first row to 0
        if(firstRow) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Set first column to 0
        if(firstCol) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna