package Solutions.LongestCommonPrefix;

/**
 * @author Daniel Atlas
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String cur = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(cur)!=0){
                cur = cur.substring(0, cur.length()-1);
                if("".equals(cur)){
                    return cur;
                }
            }
        }
        return cur;
    }
}
