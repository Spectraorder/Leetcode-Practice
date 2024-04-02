package Solutions.IsomorphicStrings;

import java.util.HashMap;

/**
 * 2024/4/1
 *
 * @author Daniel Atlas
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] freqS = new int[200];
        int[] freqT = new int[200];

        int len = s.length();

        if(len != t.length()) {
            return false;
        }

        for(int i = 0; i < len; i++) {
            if(freqS[s.charAt(i)] != freqT[t.charAt(i)]) {
                return false;
            }
            freqS[s.charAt(i)] = i + 1;
            freqT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
