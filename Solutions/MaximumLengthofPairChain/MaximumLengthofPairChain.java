package Solutions.MaximumLengthofPairChain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2023/8/26
 *
 * @author Daniel Atlas
 */
public class MaximumLengthofPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{7,8},{4,5}};
        System.out.println(findLongestChain(pairs));
    }

    public static int longestPairChain(int i, int[][] pairs, int n, int[] memo) {
        if (memo[i] != 0) {
            return memo[i];
        }
        memo[i] = 1;
        for (int j = i + 1; j < n; j++) {
            if (pairs[i][1] < pairs[j][0]) {
                memo[i] = Math.max(memo[i], 1 + longestPairChain(j, pairs, n, memo));
            }
        }
        return memo[i];
    }

    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] memo = new int[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, longestPairChain(i, pairs, n, memo));
        }
        return ans;
    }
}
