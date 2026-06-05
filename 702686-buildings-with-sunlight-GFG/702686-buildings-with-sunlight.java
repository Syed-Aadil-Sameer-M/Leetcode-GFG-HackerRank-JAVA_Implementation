class Solution {
    public int visibleBuildings(int arr[]) {
        int count = 0;
        int maxHeight = Integer.MIN_VALUE;

        for (int height : arr) {
            if (height >= maxHeight) {
                count++;
                maxHeight = height;
            }
        }

        return count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna