package Solutions.ValidAnagram;

import java.util.Arrays;

/**
 * 2023/12/15
 *
 * @author Daniel Atlas
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] alpha = new char[26];
        for(char c : s.toCharArray()){
            alpha[c-'a']++;
        }
        for(char c : t.toCharArray()){
            alpha[c-'a']--;
        }
        return Arrays.equals(alpha, new char[26]);
    }
}
