package Solutions.IsSubsequence;

/**
 * 2023/9/22
 *
 * @author Daniel Atlas
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int pos = 0;
        int posT = 0;
        while(pos<s.length()){
            if(posT == t.length()){
                return false;
            }
            if(t.charAt(posT)==s.charAt(pos)){
                pos++;
            }
            posT++;
        }
        return true;
    }
}
