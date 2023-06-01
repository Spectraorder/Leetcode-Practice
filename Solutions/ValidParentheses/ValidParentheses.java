package Solutions.ValidParentheses;

import java.util.Stack;

/**
 * @author Daniel Atlas
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "([)]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
