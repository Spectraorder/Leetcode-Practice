package Solutions.ImplementStackusingQueues;

import java.util.ArrayList;

/**
 * 2023/8/27
 *
 * @author Daniel Atlas
 */
public class MyStack {

    public ArrayList<Integer> stack;
    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
