public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        char l1 = '(', r1 = ')', l2 = '[', r2 = ']', l3 = '{', r3 = '}';
        map.put(l1, r1);
        map.put(l2, r2);
        map.put(l3, r3);
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
