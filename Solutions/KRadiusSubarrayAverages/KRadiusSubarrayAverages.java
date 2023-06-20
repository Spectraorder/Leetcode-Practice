package Solutions.KRadiusSubarrayAverages;

import java.util.Arrays;

/**
 * 2023/6/19
 *
 * @author Daniel Atlas
 */
public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int[] nums2 = new int[100000];
        Arrays.fill(nums2, 100000);
        int k = 40000;
        System.out.println(Arrays.toString(getAverages(nums2, k)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);
        if(nums.length<2*k+1){
            return output;
        }
        long sum = 0;
        for(int i=0;i<2*k+1;i++){
            sum += nums[i];
        }
        for(int i=k;i<nums.length-k;i++){
            output[i] = (int) (sum / (2*k+1));
            sum += i+k+1<nums.length ? nums[i+k+1] : 0;
            sum -= nums[i-k];
        }
        return output;
    }
}
