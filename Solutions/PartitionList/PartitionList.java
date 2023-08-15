package Solutions.PartitionList;

import java.util.ArrayList;

/**
 * 2023/8/15
 *
 * @author Daniel Atlas
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode two_1 = new ListNode(2);
        ListNode five = new ListNode(5, two_1);
        ListNode two_2 = new ListNode(2, five);
        ListNode three = new ListNode(3, two_2);
        ListNode four = new ListNode(4, three);
        ListNode head = new ListNode(1, four);
        int x = 3;
        beautyPrint(partition(head, x));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode smallHead = small;
        ListNode bigHead = big;
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }
            else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
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
