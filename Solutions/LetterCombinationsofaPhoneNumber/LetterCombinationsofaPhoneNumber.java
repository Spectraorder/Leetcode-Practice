package Solutions.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2023/8/2
 *
 * @author Daniel Atlas
 */
public class LetterCombinationsofaPhoneNumber {
    public static HashMap<Integer, String> ref = new HashMap<>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> all = new ArrayList<>();
        if(digits.isEmpty()){
            return null;
        }
        StringBuilder cur = new StringBuilder();
        return recur(digits, cur, 0, all);
    }

    public static List<String> recur(String digits, StringBuilder cur, int pos, List<String> all){
        if(pos==digits.length()){
            all.add(cur.toString());
            return all;
        }
        String pref = ref.get(digits.charAt(pos)-'0');
        for(char pre : pref.toCharArray()){
            cur.append(pre);
            recur(digits, cur, pos+1, all);
            cur.deleteCharAt(cur.length()-1);
        }
        return all;
    }
}
