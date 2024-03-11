package Solutions.CustomSortString;

import java.util.HashMap;

/**
 * 2024/3/10
 *
 * @author Daniel Atlas
 */
public class CustomSortString {
    public static void main(String[] args) {
        String order = "bcafg", s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(char cur : s.toCharArray()){
            count.put(cur, count.getOrDefault(cur, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char cur : order.toCharArray()){
            if(count.containsKey(cur)){
                if(count.get(cur)!=0){
                    int t = count.get(cur);
                    while(t-->0){
                        sb.append(cur);
                    }
                    count.put(cur, 0);
                }
            }
        }
        for(char key : count.keySet()){
            if(count.get(key)!=0){
                int t = count.get(key);
                while(t-->0){
                    sb.append(key);
                }
            }
        }
        return sb.toString();
    }
}
