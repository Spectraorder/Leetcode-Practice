package Solutions.ReverseLinkedListII;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2023/9/6
 *
 * @author Daniel Atlas
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);
        beautyPrint(head);
        beautyPrint(reverseBetween(head, 2, 5));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int pos = 1;
        ListNode cur = head;
        ListNode[] reverse = new ListNode[right-left+3];
        while(cur!=null){
            if(pos>=left&&pos<=right){
                ListNode nextNode = cur.next;
                cur.next = null;
                reverse[pos-left+1] = cur;
                cur = nextNode;
            }
            else if(pos>right){
                reverse[reverse.length-1] = cur;
                break;
            }
            else{
                reverse[0] = cur;
                cur = cur.next;
            }
            pos++;
        }
        for(int i=reverse.length-2;i>1;i--){
            reverse[i].next = reverse[i-1];
        }
        if(left!=1){
            reverse[0].next = reverse[reverse.length-2];
        }
        else{
            head = reverse[reverse.length-2];
        }
        if(reverse[reverse.length-1]!=null){
            reverse[1].next = reverse[reverse.length-1];
        }
        return head;
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
