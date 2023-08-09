package Solutions.MinimizetheMaximumDifferenceofPairs;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 2023/8/8
 *
 * @author Daniel Atlas
 */
public class MinimizetheMaximumDifferenceofPairs {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3,2,1,2};
        int p = 3;
        System.out.println(minimizeMax(nums, p));
    }

    public static int minimizeMax(int[] nums, int p) {
        if(p==0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length-1]-nums[0];
        while(left<right){
            int mid = left + (right - left) / 2;
            if (countValidPairs(nums, mid) >= p) {
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    private static int countValidPairs(int[] nums, int threshold) {
        int index = 0, count = 0;
        while(index<nums.length-1){
            if(nums[index+1]-nums[index]<=threshold){
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
}
