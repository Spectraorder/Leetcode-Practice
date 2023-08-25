package Solutions.InterleavingString;

/**
 * 2023/8/24
 *
 * @author Daniel Atlas
 */
public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s2.length()+s1.length()){
            return false;
        }
        return helper(s1, s2, s3, 0, 0);
    }

    public static boolean helper(String s1, String s2, String s3, int pos1, int pos2){
        if(pos1+pos2==s3.length()){
            return true;
        }
        char cur = s3.charAt(pos1+pos2);
        if(pos1<s1.length()&&pos2<s2.length()){
            if(s1.charAt(pos1)==s2.charAt(pos2)&&s1.charAt(pos1)==cur){
                return helper(s1, s2, s3, pos1+1, pos2) || helper(s1, s2, s3, pos1, pos2+1);
            }
        }
        if(pos1<s1.length()){
            if(s1.charAt(pos1)==cur){
                return helper(s1, s2, s3, pos1+1, pos2);
            }
        }
        if(pos2<s2.length()){
            if(s2.charAt(pos2)==cur){
                return helper(s1, s2, s3, pos1, pos2+1);
            }
        }
        return false;
    }
}
