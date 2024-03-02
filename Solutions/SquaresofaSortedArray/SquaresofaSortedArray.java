package Solutions.SquaresofaSortedArray;

import java.util.Arrays;

/**
 * 2024/3/2
 *
 * @author Daniel Atlas
 */
public class SquaresofaSortedArray {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                break;
            }
            nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        return nums;
    }
}
