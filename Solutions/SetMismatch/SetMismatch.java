package Solutions.SetMismatch;

import java.util.Arrays;

/**
 * 2024/1/21
 *
 * @author Daniel Atlas
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        boolean[] check = new boolean[nums.length];
        int[] ans = new int[2];
        for(int k : nums){
            if(!check[k-1]){
                check[k-1] = true;
            }
            else{
                ans[0] = k;
            }
        }
        for(int i=0;i<check.length;i++){
            if(!check[i]){
                ans[1] = i+1;
            }
        }
        return ans;
    }
}
