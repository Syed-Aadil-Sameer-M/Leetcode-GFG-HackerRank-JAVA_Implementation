import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 ||
            words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        if (s.length() < totalLen) {
            return result;
        }

        // Frequency map of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try each possible offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Valid word
                if (wordCount.containsKey(word)) {

                    window.put(word,
                            window.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink window if frequency exceeds
                    while (window.get(word) > wordCount.get(word)) {

                        String leftWord =
                                s.substring(left, left + wordLen);

                        window.put(leftWord,
                                window.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    // Found valid window
                    if (count == numWords) {
                        result.add(left);

                        // Slide window forward
                        String leftWord =
                                s.substring(left, left + wordLen);

                        window.put(leftWord,
                                window.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                } else {
                    // Reset window
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna