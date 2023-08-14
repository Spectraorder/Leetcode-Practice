package Solutions.KthLargestElementinanArray;

import java.util.Arrays;

/**
 * 2023/8/14
 *
 * @author Daniel Atlas
 */
public class KthLargestElementinanArray {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
