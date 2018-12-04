class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // String s = sortString(str);
            String s = compactString(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }

    public String compactString(String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                sb.append((char)(i + 'a'));
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    // public String sortString(String str) {
    //     char[] chars = str.toCharArray();
    //     Arrays.sort(chars);
    //     return new String(chars);
    // }
}