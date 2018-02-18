
class Solution {

    public String[] betterSplit(String s, char d) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != d) {
                sb.append(c);
            } else {
                if (sb.length() != 0) list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0) list.add(sb.toString());
        return list.toArray(new String[list.size()]);
    }

    public String simplifyPath(String path) {
        String[] tokens = betterSplit(path, '/');
        System.out.println(Arrays.asList(tokens));
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else if (!s.equals(".")) {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append('/').append(s);
        }
        if (sb.length() == 0) {
            return "/";
        } else {
            return sb.toString();
        }
    }
}