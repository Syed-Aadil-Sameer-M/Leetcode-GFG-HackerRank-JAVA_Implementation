class Solution {
    public int findMin(int a, int b) {
        // Initialize min with the first basic operation
        int minVal = a + b;
        
        // Compare with subtraction and multiplication
        minVal = Math.min(minVal, a - b);
        minVal = Math.min(minVal, a * b);
        
        // Use Exception Handling for the division operation
        try {
            int div = a / b;
            minVal = Math.min(minVal, div);
        } catch (ArithmeticException e) {
            // If b is 0, division is impossible; 
            // The catch block safely ignores it, leaving minVal unchanged.
        }
        
        return minVal;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna