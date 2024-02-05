package Solutions.FirstUniqueCharacterinaString;

import java.util.HashMap;

/**
 * 2024/2/4
 *
 * @author Daniel Atlas
 */
public class FirstUniqueCharacterinaString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(char cur : s.toCharArray()){
            count.put(cur, count.getOrDefault(cur, 0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(count.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
