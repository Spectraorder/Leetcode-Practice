package Solutions.ExtraCharactersinaString;

import java.util.HashSet;
import java.util.Set;

/**
 * 6/12/2023
 *
 * @author Daniel Atlas
 */
public class ExtraCharactersinaString {
    public static void main(String[] args) {
        String s = "sayhelloworld";
        String[] dictionary = {"hello","world"};
        System.out.println(minExtraChar(s, dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (String word : dictionary) {
            dict.add(word);
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = i - 1; j >= 0; j--) {
                String substring = s.substring(j, i);
                if (dict.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[n];
    }
}
