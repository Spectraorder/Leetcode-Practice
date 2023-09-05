package Solutions.CopyListwithRandomPointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author SpectraDomain
 */
public class CopyListwithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node two = new Node(2);
        two.random = two;
        head.next = two;
        head.random = two;
        Node copy = copyRandomList(head);
        beautyPrint(copy);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            Node new_node = new Node(curr.val);
            new_node.next = curr.next;
            curr.next = new_node;
            curr = new_node.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }

        Node old_head = head;
        Node new_head = head.next;
        Node curr_old = old_head;
        Node curr_new = new_head;

        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return new_head;
    }

    public static void beautyPrint(Node head){
        ArrayList<int[]> all = new ArrayList<>();
        while(head!=null){
            all.add(new int[]{head.val, head.random.val});
            head = head.next;
        }
        for(int[] cur : all){
            System.out.println(Arrays.toString(cur));
        }
    }
}
