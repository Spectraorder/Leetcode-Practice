package Solutions.RotateList;

import java.util.ArrayList;

/**
 * @author Daniel Atlas
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        beautyPrint(rotateRight(one, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode cur = head;
        int count = 1;
        while(cur.next!=null){
            cur = cur.next;
            count++;
        }
        int t = k%count;
        if(t==0){
            return head;
        }
        ListNode out = new ListNode();
        ListNode sta = head;
        cur = sta;
        for(int i=1;i<count-t;i++){
            cur = cur.next;
        }
        ListNode split = new ListNode();
        if(cur.next!=null){
            split = cur.next;
            out = split;
        }
        cur.next = null;
        while(split.next!=null){
            split = split.next;
        }
        split.next = sta;
        return out;
    }

    public static void beautyPrint(ListNode cur){
        ArrayList<Integer> out = new ArrayList<Integer>();
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
