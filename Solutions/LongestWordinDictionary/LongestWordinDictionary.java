package Solutions.LongestWordinDictionary;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Daniel Atlas
 */
public class LongestWordinDictionary {
    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        HashSet<String> all = new HashSet<>(Arrays.asList(words));
        String ans = "";
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!all.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }
        }
        return ans;
    }
}
