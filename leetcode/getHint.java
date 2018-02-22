class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int sameCharSamePos = 0;
        int sameCharDiffPos = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g) {
                if (!map.containsKey(s)) {
                    map.put(s, 1);
                } else {
                    map.put(s, map.get(s) + 1);
                }
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g) {
                ++sameCharSamePos;
            } else {
                if (map.containsKey(g) && map.get(g) > 0) {
                    ++sameCharDiffPos;
                    map.put(g, map.get(g) - 1);
                }
            }
        }
        return sameCharSamePos + "A" + sameCharDiffPos + "B";
    }
}