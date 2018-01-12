class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char [] chars = prev.toCharArray();
        int count = 0;
        for (int i = 0; i <=chars.length; i++) {
            if (i == chars.length || i >= 1 && chars[i - 1] != chars[i]) {
                sb.append(count);
                sb.append(chars[i - 1]);
                count = 0;
            }
            ++count;
        }
        return sb.toString();
    }
}