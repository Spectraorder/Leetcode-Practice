package Solutions.MinimumSizeSubarraySum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 2023/7/5
 *
 * @author Daniel Atlas
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        ArrayList<Integer> subLen = new ArrayList<>();
        int start = 0, end = 0;
        int sum = 0;
        while(end<nums.length){
            while(sum<target&&end<nums.length){
                sum += nums[end];
                end++;
            }
            if(sum>=target){
                subLen.add(end-start);
                sum -= nums[start];
                start++;
            }
        }
        while(sum>=target){
            subLen.add(end-start);
            sum -= nums[start];
            start++;
        }
        if(subLen.isEmpty()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(Integer cur : subLen){
            min = Math.min(min, cur);
        }
        return min;
    }
}
