class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < num2.length(); i++) {
            s2.push(num2.charAt(i));
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int basePow = 0;
        while (!s2.isEmpty()) {
            int v2 = Character.getNumericValue(s2.pop());
            for (int i = num1.length() - 1; i >= 0; i--) {
                int pow = basePow + (num1.length() - 1) - i;
                int v1 = Character.getNumericValue(num1.charAt(i));
                int v = v1 * v2;
                if (v >= 10) {
                    map.putIfAbsent(pow + 1, new ArrayList<>());
                    map.get(pow + 1).add(v / 10);
                }
                map.putIfAbsent(pow, new ArrayList<>());
                map.get(pow).add(v % 10);
            }
            basePow++;
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        for (int i = 0; i < map.size(); i++) {
            int r = map.get(i).stream().mapToInt(Integer::intValue).sum() + rem;
            System.out.println("r: " + r);
            if (r >= 10) {
                rem = r / 10;
            } else {
                rem = 0;
            }
            sb.insert(0, String.valueOf(r % 10));
        }
        if (rem > 0) {
            sb.insert(0, String.valueOf(rem));
        }
        return sb.toString();
    }
}