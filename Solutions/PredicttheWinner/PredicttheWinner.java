package Solutions.PredicttheWinner;

/**
 * 2023/7/27
 *
 * @author Daniel Atlas
 */
public class PredicttheWinner {
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        return maxDiff(nums, 0, nums.length-1, nums.length) >= 0;
    }

    public static int maxDiff(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }
        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);
        return Math.max(scoreByLeft, scoreByRight);
    }
}
