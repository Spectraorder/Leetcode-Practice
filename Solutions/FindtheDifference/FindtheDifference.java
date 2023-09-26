package Solutions.FindtheDifference;

import java.util.HashMap;

/**
 * 2023/9/25
 *
 * @author Daniel Atlas
 */
public class FindtheDifference {
    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char cur : s.toCharArray()){
            freq.put(cur, freq.getOrDefault(cur, 0)+1);
        }
        for(char cur : t.toCharArray()){
            freq.put(cur, freq.getOrDefault(cur, 0)-1);
        }
        for(char cur : freq.keySet()){
            if(freq.get(cur)!=0){
                return cur;
            }
        }
        return ' ';
    }
}
