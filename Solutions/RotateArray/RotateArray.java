package Solutions.RotateArray;

/**
 * @author Daniel Atlas
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for(int i : nums){
            System.out.print(i);
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] out = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i<k){
                out[i] = nums[nums.length-k+i];
            }
            else{
                out[i] = nums[i-k];
            }
        }
        System.arraycopy(out, 0, nums, 0, nums.length);
    }
}
