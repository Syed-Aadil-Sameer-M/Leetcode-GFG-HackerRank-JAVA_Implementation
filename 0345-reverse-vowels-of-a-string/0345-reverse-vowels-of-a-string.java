class Solution {
    public String reverseVowels(String s) {

        char[] c = s.toCharArray();

        int i = 0;
        int j = c.length - 1;

        while (i < j) {

            while (i < j && !isVowel(c[i])) {
                i++;
            }

            while (i < j && !isVowel(c[j])) {
                j--;
            }

            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;

            i++;
            j--;
        }

        return new String(c);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna