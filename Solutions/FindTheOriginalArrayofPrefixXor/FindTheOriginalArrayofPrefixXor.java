package Solutions.FindTheOriginalArrayofPrefixXor;

import java.util.Arrays;

/**
 * 2023/10/30
 *
 * @author Daniel Atlas
 */
public class FindTheOriginalArrayofPrefixXor {
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1};
        System.out.println(Arrays.toString(findArray(pref)));
    }

    public static int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        int iter = ans[0];
        for(int i=1;i<pref.length;i++){
            ans[i] = iter ^ pref[i];
            iter = iter ^ ans[i];
        }

        return ans;
    }
}
