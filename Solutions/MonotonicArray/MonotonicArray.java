package Solutions.MonotonicArray;

/**
 * 6/15/2023
 *
 * @author Daniel Atlas
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        int diff = 0;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev<nums[i]){
                if(diff<0){
                    return false;
                }
                diff = 1;
            }
            else if(prev>nums[i]){
                if(diff>0){
                    return false;
                }
                diff = -1;
            }
            prev = nums[i];
        }
        return true;
    }
}
