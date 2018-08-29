import java.util.*;
class Main {

    public static Set<Character> OPERATORS = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public static int priority(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else return 0;
    }
    public static String infixToPrefix(String infix) {
        Stack<Character> opStack = new Stack<>();
        Stack<Character> output = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = infix.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == ')') {
                opStack.push(c);
            } else if (Character.isDigit(c) || Character.isAlphabetic(c))  {
                output.push(c);
            } else if (c == '(') {
                while (opStack.peek() != ')') {
                    output.push(opStack.pop());
                }
                opStack.pop();
            } else if (OPERATORS.contains(c)) {
                while (!opStack.isEmpty() && priority(opStack.peek()) >= priority(c)) {
                    output.push(opStack.pop());
                }
                opStack.push(c);
            }
        }

        while (!opStack.isEmpty()) {
            sb.append(opStack.pop());
        }
        while (!output.isEmpty()) {
            sb.append(output.pop());
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(infixToPrefix("7+2*(3-5)"));
        System.out.println(infixToPrefix("4+2*3"));
    }
}