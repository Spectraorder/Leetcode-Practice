package Solutions.UniqueNumberofOccurrences;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2024/1/16
 *
 * @author Daniel Atlas
 */
public class UniqueNumberofOccurrences {
    public static void main(String[] args) {
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int cur : arr){
            counts.put(cur, counts.getOrDefault(cur, 0)+1);
        }
        HashSet<Integer> unique = new HashSet<>();
        for(int cur : counts.values()){
            if(unique.contains(cur)){
                return false;
            }
            unique.add(cur);
        }
        return true;
    }
}
