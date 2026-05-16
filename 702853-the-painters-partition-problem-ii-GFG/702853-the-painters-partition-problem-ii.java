class Solution {
    public int minTime(int[] arr, int k) {
        int n = arr.length;

        // If there are more painters than boards, allocation is not possible
        if (n < k) {
            return -1;
        }

        // Initialize the binary search bounds
        int low = 0; // Minimum possible time (max single board length)
        int high = 0; // Maximum possible time (sum of all board lengths)

        for (int length : arr) {
            low = Math.max(low, length); // max single board length
            high += length; // total length of all boards
        }

        // Perform binary search
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, k, mid)) {
                high = mid; // Try for a smaller maximum time
            } else {
                low = mid + 1; // Increase the maximum time
            }
        }

        return low; // This will be the minimum maximum time
    }

    // Helper function to check if allocation is feasible
    private boolean isFeasible(int[] arr, int k, int maxTime) {
        int paintersRequired = 1; // Start with one painter
        int currentTime = 0;

        for (int length : arr) {
            // If adding this board exceeds maxTime, allocate to the next painter
            if (currentTime + length > maxTime) {
                paintersRequired++;
                currentTime = length; // Start with the current board
                // If painters exceed k, return false
                if (paintersRequired > k) {
                    return false;
                }
            } else {
                currentTime += length; // Add board length to current painter's time
            }
        }
        return true; // Allocation is feasible
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna