package Solutions.SplitLinkedListinParts;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2023/9/5
 *
 * @author Daniel Atlas
 */
public class SplitLinkedListinParts {
    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2, three);
        ListNode head = new ListNode(1, two);
        beautyPrint(splitListToParts(head, 5));
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            count++;
        }
        int[] num = new int[k];
        Arrays.fill(num, count/k);
        for(int i=0;i<count%k;i++){
            num[i]++;
        }
        ListNode iter = head;
        ListNode prevH = head;
        int cons = 0, pos = 0;
        ListNode[] output = new ListNode[k];
        while(iter!=null){
            cons++;
            if(cons==num[pos]){
                ListNode temp = iter.next;
                iter.next = null;
                output[pos] = prevH;
                iter = temp;
                prevH = iter;
                cons = 0;
                pos++;
            }
            else{
                iter = iter.next;
            }
        }
        return output;
    }

    public static void beautyPrint(ListNode[] all){
        for(ListNode listNode : all){
            ArrayList<Integer> cur = new ArrayList<>();
            ListNode head = listNode;
            while (head != null) {
                cur.add(head.val);
                head = head.next;
            }
            System.out.println(cur);
        }
    }
}
