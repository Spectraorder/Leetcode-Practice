package Solutions.LinkedListCycle;

import java.util.HashSet;

/**
 * 2023/9/4
 *
 * @author Daniel Atlas
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode four = new ListNode(4);
        head.next = two;
        two.next = zero;
        zero.next = four;
        four.next = two;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> all = new HashSet<>();
        while(head!=null){
            if(all.contains(head)){
                return true;
            }
            all.add(head);
            head = head.next;
        }
        return false;
    }
}
