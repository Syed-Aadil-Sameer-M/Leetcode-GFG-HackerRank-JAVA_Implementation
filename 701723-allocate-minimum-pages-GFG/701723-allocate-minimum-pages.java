class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;

        // If there are more students than books, allocation is not possible
        if (n < k) {
            return -1;
        }

        // Initialize the binary search bounds
        int low = 0; // minimum pages (max single book pages)
        int high = 0; // maximum pages (sum of all book pages)

        for (int pages : arr) {
            low = Math.max(low, pages); // max pages in a single book
            high += pages; // total pages
        }

        // Perform binary search
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, k, mid)) {
                high = mid; // try for a smaller maximum
            } else {
                low = mid + 1; // increase the maximum
            }
        }

        return low; // This will be the minimum maximum pages
    }

    // Helper function to check feasibility of allocation
    private boolean isFeasible(int[] arr, int k, int maxPages) {
        int studentsRequired = 1; // start with one student
        int currentPages = 0;

        for (int pages : arr) {
            // If adding this book exceeds maxPages, allocate to the next student
            if (currentPages + pages > maxPages) {
                studentsRequired++;
                currentPages = pages; // start with the current book
                // If students exceed k, return false
                if (studentsRequired > k) {
                    return false;
                }
            } else {
                currentPages += pages; // add pages to current student
            }
        }
        return true; // allocation is feasible
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna