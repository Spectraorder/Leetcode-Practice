package Solutions.MaximumAbsoluteSumofAnySubarray;

/**
 * @author Daniel Atlas
 */
public class MaximumAbsoluteSumofAnySubarray {
    public static void main(String[] args) {
        int[] nums = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int max = 0, sum = 0, min = 0;
        for(int num : nums){
            sum += num;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        return max-min;
    }
}
