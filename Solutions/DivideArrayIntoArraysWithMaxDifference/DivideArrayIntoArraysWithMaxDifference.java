package Solutions.DivideArrayIntoArraysWithMaxDifference;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2024/1/31
 *
 * @author Daniel Atlas
 */
public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println(Arrays.deepToString(divideArray(nums, k)));
    }

    public static int[][] divideArray(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int cur : nums){
            pq.add(cur);
        }
        int[][] output = new int[nums.length/3][3];
        int pos = 0;
        while(!pq.isEmpty()){
            int[] addon = new int[3];
            for(int i=0;i<3;i++){
                addon[i] = pq.poll();
            }
            if(addon[2] - addon[0]>k){
                return new int[0][0];
            }
            output[pos] = addon;
            pos++;
        }
        return output;
    }
}
