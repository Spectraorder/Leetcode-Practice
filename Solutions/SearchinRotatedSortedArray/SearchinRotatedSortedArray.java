package Solutions.SearchinRotatedSortedArray;

/**
 * 2023/8/7
 *
 * @author Daniel Atlas
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length;
        while(start<=end){
            int mid = (start+end) / 2;
            if(nums[mid]>nums[nums.length-1]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        int binSL = 0, binEL = start - 1;
        while(binSL<=binEL){
            int mid = (binSL+binEL) / 2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                binEL = mid - 1;
            }
            else{
                binSL = mid + 1;
            }
        }
        binSL = start;
        binEL = nums.length-1;
        while(binSL<=binEL){
            int mid = (binSL+binEL) / 2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                binEL = mid - 1;
            }
            else{
                binSL = mid + 1;
            }
        }
        return -1;
    }
}
