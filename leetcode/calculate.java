class Solution {
    Set<Character> ops = new HashSet<>(Arrays.asList('+', '-', '/', '*'));
    public int calculate(String s) {
        s = s.replaceAll("\\s","");
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<String> stack = new Stack<>();
        // first pass only evaluate * and /
        int i = 0;
        while (i < n) {
            char curr = chars[i];
            if (ops.contains(curr)) {
                stack.push(Character.toString(curr));
                ++i;
            }
            else {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isDigit(chars[i])) {
                    sb.append(chars[i]);
                    ++i;
                }
                String s1 = sb.toString();
                if (!stack.isEmpty() && (stack.peek().equals("/") || stack.peek().equals("*"))) {
                    String op = stack.pop();
                    String prev = stack.pop();
                    int i0 = Integer.parseInt(prev);
                    int i1 = Integer.parseInt(s1);
                    if (op.equals("*")) {
                        stack.push(Integer.toString(i0 * i1));
                    } else {
                        stack.push(Integer.toString(i0 / i1));
                    }
                } else {
                    stack.push(s1);
                }
            }
        }
        // now stack is just string + and -
        int res = 0;
        int prev = 0;
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.equals("+") || cur.equals("-")) {
                if (cur.equals("-")) {
                    res -= 2 * prev;
                }
            } else {
                prev = Integer.parseInt(cur);
                res += prev;
            }
        }
        return res;

    }
}