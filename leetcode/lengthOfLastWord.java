class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean startWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && startWord) {
                break;
            } else if (s.charAt(i) != ' ') {
                startWord = true;
                ++len;
            }
        }
        return len;
    }
}