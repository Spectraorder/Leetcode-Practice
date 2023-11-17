package Solutions.MinimizeMaximumPairSuminArray;

import java.util.Arrays;

/**
 * 2023/11/17
 *
 * @author Daniel Atlas
 */
public class MinimizeMaximumPairSuminArray {
    public static void main(String[] args) {
        int[] nums = {3,5,2,3};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int output = Integer.MIN_VALUE;
        for(int i=0;i<nums.length/2;i++){
            output = Math.max(output, nums[i] + nums[nums.length-1-i]);
        }
        return output;
    }
}
