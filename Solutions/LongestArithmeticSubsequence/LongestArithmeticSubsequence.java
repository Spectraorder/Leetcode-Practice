package Solutions.LongestArithmeticSubsequence;

import java.util.HashMap;

/**
 * 2023/6/22
 *
 * @author Daniel Atlas
 */
public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        int[] nums = {20,1,15,3,10,5,8};
        System.out.println(longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int right = 0; right < nums.length; ++right) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; ++left) {
                int diff = nums[left] - nums[right];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        return maxLength;
    }
}
