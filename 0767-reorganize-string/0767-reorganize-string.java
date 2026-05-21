class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // Max-heap based on remaining count
        java.util.PriorityQueue<int[]> maxHeap = new java.util.PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null; // holds previous character with remaining count
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            sb.append((char) (cur[0] + 'a'));
            cur[1]--; // used one occurrence
            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }
            prev = cur[1] > 0 ? cur : null;
        }
        // If we couldn't use all characters, arrangement is impossible
        return sb.length() == s.length() ? sb.toString() : "";
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna