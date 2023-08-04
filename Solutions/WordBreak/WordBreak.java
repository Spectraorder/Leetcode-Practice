package Solutions.WordBreak;

import java.util.*;

/**
 * 2023/8/3
 *
 * @author Daniel Atlas
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>(List.of(new String[]{"apple", "pen"}));
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }
                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }
        return false;
    }
}
