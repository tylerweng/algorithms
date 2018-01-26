class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean isNegative = x < 0;
        if (isNegative) {
            x *= -1;
        }
        while (x > 0) {
            int lastDigit = x % 10;
            int newRes = res * 10 + lastDigit;
            if ((newRes - lastDigit) / 10 != res) {
                return 0;
            } else {
                res = newRes;
            }
            x = x / 10;
        }
        return isNegative ? -1 * res : res;
    }
}