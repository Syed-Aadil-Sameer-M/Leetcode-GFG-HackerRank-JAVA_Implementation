class Solution {
    public static int nextPrime(int n) {
        int candidate = n + 1;
        
        // Loop infinitely until we find the next prime number
        while (true) {
            if (isPrime(candidate)) {
                return candidate;
            }
            candidate++;
        }
    }
    
    // Helper method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        // Check factors up to the square root using 6k +/- 1 optimization
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna