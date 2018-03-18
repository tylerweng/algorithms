class Solution {
    public int maximumSwap(int num) {
        if (num == 0) return 0;
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int n = digits.size();
        int swapIdxI = n - 1;
        int swapIdxJ = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int maxDigit = digits.get(i);
            swapIdxI = i;
            swapIdxJ = i;
            for (int j = i - 1; j >= 0; j--) {
                if (digits.get(j) >= maxDigit &&  digits.get(j) > digits.get(i)) {
                    swapIdxJ = j;
                    maxDigit = digits.get(j);
                }
            }
            if (swapIdxI != swapIdxJ) break;
        }
        Collections.swap(digits, swapIdxI, swapIdxJ);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.pow(10, i) * digits.get(i);
        }
        return res;
    }
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        // buckets store furthest right idx (smallest 10 pow val) of each digit
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }
}