package Solutions.AddTwoNumbersII;

/**
 * 2023/7/16
 *
 * @author Daniel Atlas
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4, three);
        ListNode two = new ListNode(2, four);
        ListNode l1 = new ListNode(7, two);

        ListNode fourT = new ListNode(4);
        ListNode six = new ListNode(6, fourT);
        ListNode l2 = new ListNode(5, six);

        ListNode cur = addTwoNumbers(l1, l2);
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);

        int totalSum = 0, carry = 0;
        ListNode ans = new ListNode();
        while (r1 != null || r2 != null) {
            if (r1 != null) {
                totalSum += r1.val;
            }
            if (r2 != null) {
                totalSum += r2.val;
            }

            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;

            r1 = r1 != null ? r1.next : null;
            r2 = r2 != null ? r2.next : null;
        }

        return carry == 0 ? ans.next: ans;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, temp;
        while (head != null) {
            // Keep the next node
            temp = head.next;
            // Reverse the link
            head.next = prev;
            // Update the previous node and the current node.
            prev = head;
            head = temp;
        }
        return prev;
    }
}
