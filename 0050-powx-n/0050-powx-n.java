class Solution {
    public double myPow(double x, int n) {

        long power = n;
        boolean negative = power < 0;

        if (negative) {
            power = -power;

            if (Math.abs(x) >= 1) {
                x = 1 / x;
                negative = false;
            }
        }

        double result = 1;

        while (power > 0) {

            if (power % 2 != 0) {
                result *= x;
            }

            x *= x;
            power /= 2;
        }

        if (negative) {
            result = 1 / result;
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna