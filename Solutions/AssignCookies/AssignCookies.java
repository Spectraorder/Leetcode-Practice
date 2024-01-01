package Solutions.AssignCookies;

import java.util.Arrays;

/**
 * 2023/12/31
 *
 * @author Daniel Atlas
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {10,9,8,7}, s = {5,6,7,8};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gp = 0;
        for(int i=0;i<s.length&&gp<g.length;i++){
            if(g[gp]<=s[i]){
                gp++;
                count++;
            }
        }
        return count;
    }
}
