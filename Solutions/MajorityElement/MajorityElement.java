package Solutions.MajorityElement;

import java.util.Arrays;

/**
 * 2024/2/11
 *
 * @author Daniel Atlas
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int lastIndex = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[lastIndex]&& i-lastIndex>nums.length/2){
                return nums[i-1];
            }
        }
        return nums[0];
    }

}
