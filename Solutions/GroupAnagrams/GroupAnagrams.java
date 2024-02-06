package Solutions.GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 2024/2/5
 *
 * @author Daniel Atlas
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        result.addAll(groups.values());
        return result;
    }
}
