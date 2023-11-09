package Solutions.CountNumberofHomogenousSubstrings;

import java.util.Arrays;

/**
 * 2023/11/9
 *
 * @author Daniel Atlas
 */
public class CountNumberofHomogenousSubstrings {
    public static void main(String[] args) {
        String s = "abbcccaa";
        System.out.println(countHomogenous(s));
    }

    public static int countHomogenous(String s) {
        int ans = 0;
        int currStreak = 0;
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                currStreak++;
            } else {
                currStreak = 1;
            }

            ans = (ans + currStreak) % MOD;
        }

        return ans;
    }
}
