package Solutions.RemoveDuplicatesfromSortedArray;

/**
 * @author Daniel Atlas
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for(int k : nums){
            System.out.print(k+" ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int pos = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[pos] = nums[i];
                pos++;
            }
        }
        return pos;
    }
}
