package Solutions.EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * 2024/1/29
 *
 * @author Daniel Atlas
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for(String str : tokens){
            try{
                int cur = Integer.parseInt(str);
                numStack.push(cur);
            }
            catch (NumberFormatException e) {
                int a = numStack.pop(), b = numStack.pop();
                switch (str) {
                    case "+":
                        numStack.push(a+b);
                        break;
                    case "-":
                        numStack.push(b-a);
                        break;
                    case "*":
                        numStack.push(b*a);
                        break;
                    case "/":
                        numStack.push(b/a);
                        break;
                }
            }
        }
        return numStack.pop();
    }
}
