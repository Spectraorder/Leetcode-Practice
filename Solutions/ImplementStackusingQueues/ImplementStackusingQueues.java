package Solutions.ImplementStackusingQueues;

/**
 * 2023/8/27
 *
 * @author Daniel Atlas
 */
public class ImplementStackusingQueues {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }
}
