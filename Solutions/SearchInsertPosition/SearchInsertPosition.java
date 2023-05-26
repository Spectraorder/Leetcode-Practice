package Solutions.SearchInsertPosition;

/**
 * @author Daniel Atlas
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        return helper(nums, 0, nums.length-1, target);
    }

    public static int helper(int[] nums, int start, int end, int target){
        if(start>end||end<start){
            return Math.max(start, end);
        }
        if(start==end){
            if(nums[start]<target){
                return start+1;
            }
            else{
                return start;
            }
        }
        int mid = (start+end)/2;
        if(nums[mid]<target){
            return helper(nums, mid+1, end, target);
        }
        else if(nums[mid]>target){
            return helper(nums, start, mid-1, target);
        }
        else{
            return mid;
        }
    }
}
