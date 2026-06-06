class Solution {
    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (ch == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna