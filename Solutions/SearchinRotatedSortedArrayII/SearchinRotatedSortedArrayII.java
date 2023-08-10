package Solutions.SearchinRotatedSortedArrayII;

/**
 * 2023/8/9
 *
 * @author Daniel Atlas
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                for (int i = left; i <= right; i++) {
                    if (nums[i] == target) {
                        return true;
                    }
                }
                return false;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
