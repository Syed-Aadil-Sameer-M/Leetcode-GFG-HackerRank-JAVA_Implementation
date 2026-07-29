class Solution {
    public boolean isIsomorphic(String s, String t) {
        // If lengths are not equal, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s to t
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false; // Mismatch found
                }
            } else {
                mapST.put(charS, charT);
            }

            // Check mapping from t to s
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false; // Mismatch found
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true; // Strings are isomorphic
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna