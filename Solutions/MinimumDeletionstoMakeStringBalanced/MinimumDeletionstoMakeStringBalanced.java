package Solutions.MinimumDeletionstoMakeStringBalanced;

import java.util.HashMap;

/**
 * 2024/1/25
 *
 * @author Daniel Atlas
 */
public class MinimumDeletionstoMakeStringBalanced {
    public static void main(String[] args) {
        String s = "bbaaaaabb";
        System.out.println(minimumDeletions(s));
    }

    public static int minimumDeletions(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int countB = s.charAt(0)=='a' ? 0 : 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='b'){
                countB++;
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = Math.min(countB, dp[i-1]+1);
            }
        }
        return dp[s.length()-1];
    }
}
