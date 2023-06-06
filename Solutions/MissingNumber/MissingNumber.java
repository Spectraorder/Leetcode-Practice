package Solutions.MissingNumber;

import java.util.Arrays;

/**
 * @author Daniel Atlas
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=i){
//                return i;
//            }
//        }
//        return nums.length;
        int n = nums.length + 1;
        int total = (n * (n-1 )) / 2;

        for (int num : nums) {
            total -= num;
        }

        return total;
    }
}
