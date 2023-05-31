package Solutions.AddTwoNumbers;

import java.util.ArrayList;

/**
 * @author Daniel Atlas
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode one = new ListNode(2);
        ListNode four_1 = new ListNode(4);
        ListNode four_2 = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = four_1;
        four_1.next = three;
        five.next = six;
        six.next = four_2;
        beautyPrint(addTwoNumbers(one, five));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long x = reverse(l1);
        long y = reverse(l2);
        return toNode(x+y);
    }

    public static long reverse(ListNode cur){
        String str = "";
        while(cur.next!=null){
            str += String.valueOf(cur.val);
            cur = cur.next;
        }
        str += String.valueOf(cur.val);
        StringBuilder builder = new StringBuilder(str);
        return Long.parseLong(builder.reverse().toString());
    }

    public static ListNode toNode(long k){
        String str = String.valueOf(k);
        StringBuilder builder = new StringBuilder(str);
        str = builder.reverse().toString();
        ListNode head = new ListNode(Integer.parseInt(str.substring(0, 1)));
        ListNode cur = head;
        for(int i=1;i<str.length();i++){
            ListNode j = new ListNode(Integer.parseInt(str.substring(i, i+1)));
            cur.next = j;
            cur = cur.next;
        }
        return head;
    }

    public static void beautyPrint(ListNode cur){
        ArrayList<Integer> out = new ArrayList<>();
        if(cur!=null){
            while(cur.next!=null){
                out.add(cur.val);
                cur = cur.next;
            }
            out.add(cur.val);
            System.out.println(out);
        }
    }
}
