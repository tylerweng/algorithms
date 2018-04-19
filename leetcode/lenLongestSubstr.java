class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        // map character to its last index
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                j = Math.max(j, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}