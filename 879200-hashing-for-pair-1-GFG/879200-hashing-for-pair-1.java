import java.util.HashSet;

class Geeks {
    // Function to check if there is a pair with the given sum in the array.
    public static int sumExists(int arr[], int sum) {
        // HashSet to store the elements we have seen so far
        HashSet<Integer> seen = new HashSet<>();
        
        for (int x : arr) {
            int rem = sum - x;
            
            // If the complement exists in the set, we found the pair
            if (seen.contains(rem)) {
                return 1;
            }
            
            // Otherwise, add the current element to the set
            seen.add(x);
        }
        
        // Return 0 if no such pair exists
        return 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna