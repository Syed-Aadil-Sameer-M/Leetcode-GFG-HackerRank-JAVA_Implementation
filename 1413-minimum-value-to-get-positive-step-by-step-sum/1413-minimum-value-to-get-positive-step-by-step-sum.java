class Solution {
    public int minStartValue(int[] nums) {

        int start = 1;

        while (true) {
            int temp = start;
            boolean flag = true;

            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];

                if (temp < 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return start;
            }

            start++;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna