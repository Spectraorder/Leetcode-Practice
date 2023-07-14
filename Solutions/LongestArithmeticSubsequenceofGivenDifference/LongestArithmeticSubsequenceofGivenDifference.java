package Solutions.LongestArithmeticSubsequenceofGivenDifference;

import java.util.HashMap;

/**
 * 2023/7/13
 *
 * @author Daniel Atlas
 */
public class LongestArithmeticSubsequenceofGivenDifference {
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        int difference = -2;
        System.out.println(longestSubsequence(arr, difference));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int answer = 1;
        for (int a : arr) {
            int beforeA = dp.getOrDefault(a - difference, 0);
            dp.put(a, beforeA + 1);
            answer = Math.max(answer, dp.get(a));
        }
        return answer;
    }
}
