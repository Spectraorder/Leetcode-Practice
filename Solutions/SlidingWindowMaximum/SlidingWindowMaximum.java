package Solutions.SlidingWindowMaximum;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 2023/8/15
 *
 * @author Daniel Atlas
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k>nums.length){
            return null;
        }
        int[] output = new int[nums.length-k+1];
        PriorityQueue<Integer> cur = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            cur.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            output[i-k] = cur.poll();
            if(output[i-k]!=nums[i-k]){
                cur.add(output[i-k]);
                removeElement(cur, nums[i-k]);
            }
            cur.add(nums[i]);
        }
        output[output.length-1] = cur.poll();
        return output;
    }

    public static <T> void removeElement(PriorityQueue<T> queue, T valueToRemove) {
        Iterator<T> iterator = queue.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element.equals(valueToRemove)) {
                iterator.remove();
                break;
            }
        }
    }
}
