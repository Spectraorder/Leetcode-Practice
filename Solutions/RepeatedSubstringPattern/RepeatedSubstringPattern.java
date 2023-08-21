package Solutions.RepeatedSubstringPattern;

/**
 * 2023/8/20
 *
 * @author Daniel Atlas
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        return t.substring(1,t.length()-1).contains(s);
    }
}
