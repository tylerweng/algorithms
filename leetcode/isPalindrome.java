class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) return true;
        int max = chars.length - 1;
        int left = 0, right = max;
        while (left < right) {
            while (!Character.isDigit(chars[left]) && !Character.isLetter(chars[left])) {
                ++left;
                if (left > max) return true;
            }
            while (!Character.isDigit(chars[right]) && !Character.isLetter(chars[right])) {
                --right;
            }
            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) return false;
            ++left;
            --right;
        }
        return true;
    }
}