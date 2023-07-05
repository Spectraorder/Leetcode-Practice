package Solutions.LongestSubarrayof1sAfterDeletingOneElement;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2023/7/4
 *
 * @author Daniel Atlas
 */
public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,0,1,1,0};
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        // Number of zero's in the window.
        int zeroCount = 0;
        int longestWindow = 0;
        // Left end of the window.
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);

            // Shrink the window until the zero counts come under the limit.
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }

            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }
}
