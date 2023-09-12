package Solutions.MinimumDeletionstoMakeCharacterFrequenciesUnique;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 2023/9/12
 *
 * @author Daniel Atlas
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        String s = "bbcebab";
        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s) {
        HashMap<Character, Integer> all = new HashMap<>();
        for(char c : s.toCharArray()){
            all.put(c, all.getOrDefault(c, 0) + 1);
        }
        HashSet<Integer> saved = new HashSet<>();
        int operations = 0;
        for(int cur : all.values()){
            while(saved.contains(cur)){
                cur--;
                operations++;
                if(cur==0){
                    break;
                }
            }
            if(cur!=0){
                saved.add(cur);
            }
        }
        return operations;
    }
}
