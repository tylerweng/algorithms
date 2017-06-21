public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        char [] cc = s.toCharArray();
        int slow = 0, fast = 1;
        int [] count = new int [256];
        count[cc[slow]]++;
        while (fast < s.length()) {
            count[cc[fast]]++;
            while (slow < s.length() && count[cc[slow]] > 1) slow++;
            if (slow >= s.length()) return -1;
            fast++;
        }
        return slow;
    }
}
