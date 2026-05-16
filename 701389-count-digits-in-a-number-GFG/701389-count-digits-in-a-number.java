class Solution {
    public static int countDigits(int n) {
        // Math.log10(n) gives the power of 10. 
        // For example, Math.log10(1567) is ~3.195. Taking the floor gives 3, plus 1 equals 4.
        return (int) Math.floor(Math.log10(n)) + 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna