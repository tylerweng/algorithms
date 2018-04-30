class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int longest = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(0);
            } else {
                if (stack.size() > 1) {
                    stack.add(stack.pop() + stack.pop() + 2);
                    longest = Math.max(longest, stack.peek());
                } else {
                    stack = new Stack<>();
                    stack.add(0);
                }
            }
        }
        return longest;
    }
}