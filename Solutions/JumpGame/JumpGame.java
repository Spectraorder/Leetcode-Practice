package Solutions.JumpGame;

/**
 * 6/11/2023
 *
 * @author Daniel Atlas
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
//        return helpJump(nums, 0);
        if(nums.length <= 1){
            return true;
        }
        int stepsleft = nums[0];
        int index = 1;
        while(stepsleft > 0){
            if (index == nums.length-1){
                return true;
            }
            stepsleft = Math.max(stepsleft-1, nums[index]);
            index++;
        }
        return false;
    }

    public static boolean helpJump(int[] nums, int pos){
        if(nums.length-1-pos<=nums[pos]){
            return true;
        }
        if(nums[pos]==0){
            return false;
        }
        for(int i=nums[pos];i>0;i--){
            if(helpJump(nums, pos+i)){
                return true;
            }
        }
        return false;
    }
}
